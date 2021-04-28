package com.ryan.horsegod.controllers;

import java.security.Principal;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ryan.horsegod.models.Colt;
import com.ryan.horsegod.models.Stallion;
import com.ryan.horsegod.models.User;
import com.ryan.horsegod.services.ColtService;
import com.ryan.horsegod.services.StallionService;
import com.ryan.horsegod.services.UserService;

@Controller
public class ColtControl {
	private ColtService coltServ;
	private StallionService stallServ;
	private UserService userServ;
	
	public ColtControl(ColtService coltServ, StallionService stallServ, UserService userServ) {
		this.coltServ = coltServ;
		this.stallServ = stallServ;
		this.userServ = userServ;
	}
	
	@RequestMapping(value="/createcolt", method=RequestMethod.POST)
	public String createColt(Colt c) {
		coltServ.createColt(c);
		return "redirect:/home";
	}
	
	@RequestMapping("/allcolts")
	public String allColts(Model model) {
		model.addAttribute("allColts", coltServ.allColts());
		return "/horse/colt/availablecolts.jsp";
	}
	
	@RequestMapping(value="/colt/{id}")
	public String coltInfo(@PathVariable(value="id") UUID id, Model model) {
		model.addAttribute("colt", coltServ.findColt(id));
		return "/horse/colt/coltinfo.jsp";
	}
	
	@RequestMapping(value="/coltcheckup/{id}", method=RequestMethod.POST)
	public String createTraits(@PathVariable(value="id") UUID id, @ModelAttribute(name="stallion") Stallion stallion, BindingResult result, Principal principal, Model model) {
		model.addAttribute("colt", coltServ.findColt(id));
		String username = principal.getName();
		User user = userServ.findByUsername(username);
		Colt colt = coltServ.findColt(id);
		stallion.setHeight(colt.getHeight());
		stallion.setWeight(colt.getWeight());
		stallion.setSpeed(colt.getSpeed());
		stallion.setGait(colt.getGait());
		stallion.setEndurance(colt.getEndurance());
		stallion.setColt(colt);
		stallion.setStudId(null);
		stallion.setUser(user);
		stallServ.create(stallion);
		return "redirect:/home";
	}
}
