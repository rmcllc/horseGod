package com.ryan.horsegod.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ryan.horsegod.models.Broodmare;
import com.ryan.horsegod.models.User;
import com.ryan.horsegod.services.BroodmareService;
import com.ryan.horsegod.services.UserService;

@Controller
public class BroodmareControl {
	private BroodmareService broodmareServ;
	private UserService userServ;
	
	public BroodmareControl(BroodmareService broodmareServ, UserService userServ) {
		this.broodmareServ = broodmareServ;
		this.userServ = userServ;
	}
	
	@RequestMapping(value="/marenheir", method=RequestMethod.PUT)
	public String mareCreator(@ModelAttribute("broodmare") Broodmare b) {
		broodmareServ.create(b);
		return "redirect:/home";
	}
	
	@RequestMapping("/allbroods")
	public String allBroods(Principal principal, Model model) {
		String username = principal.getName();
		User user = userServ.findByUsername(username);
		List<Broodmare> brood = broodmareServ.allBroods();
		List<Broodmare> avail = new ArrayList<Broodmare>();
		for(int i=0; i<brood.size(); i++) {
			if(brood.get(i).getUser() != user) {
				avail.add(brood.get(i));
			}
		}
		model.addAttribute("allBroods", avail);
		return "/horse/broodmare/availablebroods.jsp";
	}
	
	@RequestMapping("/broodmareinfo/{id}")
	public String broodmareInfo(@PathVariable(value="id") UUID id, Model model) {
		model.addAttribute("brood", broodmareServ.findBroodById(id));
		return "/horse/mare/broodmareinfo.jsp";
	}
		
}
