package com.ryan.horsegod.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.horsegod.models.Broodmare;
import com.ryan.horsegod.models.Mare;
import com.ryan.horsegod.models.User;
import com.ryan.horsegod.services.BroodmareService;
import com.ryan.horsegod.services.ColtService;
import com.ryan.horsegod.services.DamService;
import com.ryan.horsegod.services.FillyService;
import com.ryan.horsegod.services.FoalService;
import com.ryan.horsegod.services.MareService;
import com.ryan.horsegod.services.SireService;
import com.ryan.horsegod.services.StallionService;
import com.ryan.horsegod.services.StudService;
import com.ryan.horsegod.services.UserService;

@Controller
public class MareControl {
	private UserService userServ;
	private MareService mareServ;
	private BroodmareService broodServ;

	
	public MareControl(UserService userServ, StallionService stallServ, MareService mareServ, StudService studServ, BroodmareService broodServ, DamService damServ, SireService sireServ, FoalService foalServ, ColtService coltServ, FillyService fillyServ) {
		this.mareServ = mareServ;
		this.userServ = userServ;
		this.broodServ = broodServ;
	}
	//list all available mares...mares that are not owned by the principal user
	@RequestMapping("/allmares")
	public String allMares(Principal principal, Model model) {
		String username = principal.getName();
		User user = userServ.findByUsername(username);
		List<Mare> mare = mareServ.allMares();
		List<Mare> avail = new ArrayList<Mare>();
		for(int i=0; i<mare.size(); i++) {
			if(mare.get(i).getUser() != user) {
				avail.add(mare.get(i));
			}
		}
		model.addAttribute("allMares", avail);
		return "/horse/mare/availablemares.jsp";
	}
	
	
	@RequestMapping("/mareinfo/{id}")
	public String mareInfo(@PathVariable(value="id") UUID id, Model model) {
		model.addAttribute("mare", mareServ.findMare(id));
		return "/horse/mare/mareinfo.jsp";
	}
	//creates a broodmare object containing the mare field values...updates Mare table with new Broodmare id 
	@RequestMapping("/broodfarm/{id}")
	public String mareFarm(@Valid @ModelAttribute("broodId") UUID broodId, BindingResult result, @ModelAttribute("mare") Mare mare, BindingResult result2, @ModelAttribute("broodmare") Broodmare brood, BindingResult result3, @PathVariable(value="id") UUID id, Principal principal, Model model) {
		mare = mareServ.findMare(id);
		String username = principal.getName();
		User user = userServ.findByUsername(username);
		Broodmare newBrood = new Broodmare();
		newBrood.setHeight(mare.getHeight());
		newBrood.setWeight(mare.getWeight());
		newBrood.setSpeed(mare.getSpeed());
		newBrood.setGait(mare.getGait());
		newBrood.setEndurance(mare.getEndurance());
		newBrood.setMare(mare);
		newBrood.setUser(user);
		broodServ.create(newBrood);
		broodId = newBrood.getId();
		mareServ.updateMare(id, mare.getHeight(), mare.getWeight(), mare.getSpeed(), mare.getGait(), mare.getEndurance(), broodId);
		return "redirect:/home";
	}
	
	
}
			
