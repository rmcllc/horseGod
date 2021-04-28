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

import com.ryan.horsegod.models.Filly;
import com.ryan.horsegod.models.Mare;
import com.ryan.horsegod.models.User;
import com.ryan.horsegod.services.FillyService;
import com.ryan.horsegod.services.MareService;
import com.ryan.horsegod.services.UserService;

@Controller
public class FillyControl {
	private FillyService fillyServ;
	private MareService mareServ;
	private UserService userServ;
	
	public FillyControl(FillyService fillyServ, MareService mareServ, UserService userServ) {
		this.fillyServ = fillyServ;
		this.mareServ = mareServ;
		this.userServ = userServ;
	}
	
	@RequestMapping(value="/createfilly", method=RequestMethod.POST)
	public String createFilly(Filly f) {
		fillyServ.createFilly(f);
		return "redirect:/home";
	}
	
	@RequestMapping("/allfillys")
	public String allFillys(Model model) {
		model.addAttribute("allFillys", fillyServ.allFillys());
		return "/horse/filly/availablefillys.jsp";
	}
	
	@RequestMapping("/filly/{id}")
	public String fillyInfo(@PathVariable(value="id") UUID id, Model model) {
		model.addAttribute("filly", fillyServ.findFilly(id));
		return "/horse/filly/fillyinfo.jsp";
	}
	
	@RequestMapping(value="/fillycheckup/{id}", method=RequestMethod.POST)
	public String createTraits(@PathVariable(value="id") UUID id, @ModelAttribute(name="mare") Mare mare, BindingResult result, Principal principal, Model model) {
		model.addAttribute("mare", mareServ.findMare(id));
		String username = principal.getName();
		User user = userServ.findByUsername(username);
		Filly filly = fillyServ.findFilly(id);
		mare.setHeight(filly.getHeight());
		mare.setWeight(filly.getWeight());
		mare.setSpeed(filly.getSpeed());
		mare.setGait(filly.getGait());
		mare.setEndurance(filly.getEndurance());
		mare.setFilly(filly);
		mare.setDamId(null);
		mare.setUser(user);
		mareServ.createMare(mare);
		return "redirect:/home";
	}
}
