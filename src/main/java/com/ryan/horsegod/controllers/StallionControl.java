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

import com.ryan.horsegod.models.Stallion;
import com.ryan.horsegod.models.Stud;
import com.ryan.horsegod.models.User;
import com.ryan.horsegod.services.StallionService;
import com.ryan.horsegod.services.StudService;
import com.ryan.horsegod.services.UserService;

@Controller
public class StallionControl {
	private StallionService stallServ;
	private UserService userServ;
	private StudService studServ;
	
	public StallionControl(StudService studServ, StallionService stallServ, UserService userServ) {
		this.stallServ = stallServ;
		this.userServ = userServ;
		this.studServ = studServ;
	}
	
	@RequestMapping("/allstallions")
	public String allStall(Principal principal, Model model) {
		String username = principal.getName();
		User user = userServ.findByUsername(username);
		List<Stallion> stallion = stallServ.allStallions();
		List<Stallion> avail = new ArrayList<Stallion>();
		for(int i=0; i<stallion.size(); i++) {
			if(stallion.get(i).getUser() != user) {
				avail.add(stallion.get(i));
			}
		}
		model.addAttribute("allStalls", avail);
		return "horse/stallion/availablestallions.jsp";
	}
	
	@RequestMapping(value="/stallion/{id}")
	public String stallionInfo(@PathVariable(value="id") UUID id, Model model) {
		model.addAttribute("stallion", stallServ.findStallionById(id));
		return "/horse/stallion/stallioninfo.jsp";
	}
	
	@RequestMapping("/studfarm/{id}")
	public String studFarm(@Valid @ModelAttribute("studId") UUID studId, BindingResult result3, @ModelAttribute("stud") Stud stud, BindingResult result2, @ModelAttribute("stallion") Stallion stallion, BindingResult result, @PathVariable(value="id") UUID id, Principal principal, Model model) {
		stallion = stallServ.findStallionById(id);
		String username = principal.getName();
		User user = userServ.findByUsername(username);
		Stud newStud = new Stud();
		newStud.setHeight(stallion.getHeight());
		newStud.setWeight(stallion.getWeight());
		newStud.setSpeed(stallion.getSpeed());
		newStud.setGait(stallion.getGait());
		newStud.setEndurance(stallion.getEndurance());
		newStud.setStallion(stallion);
		newStud.setUser(user);
		studServ.createStud(newStud);
		studId = newStud.getId();
		stallServ.updateStallion(id, stallion.getHeight(), stallion.getWeight(), stallion.getSpeed(), stallion.getGait(), stallion.getEndurance(), studId);
		System.out.println("Stud ID for Stallion FIELD-----------------------------------------------------------------------: " + studId);
		return "redirect:/home";
	}
}
