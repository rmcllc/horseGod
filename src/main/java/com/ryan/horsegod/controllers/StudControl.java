package com.ryan.horsegod.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ryan.horsegod.models.Mare;
import com.ryan.horsegod.models.Stud;
import com.ryan.horsegod.nodes.Node;
import com.ryan.horsegod.services.BroodmareService;
import com.ryan.horsegod.services.MareService;
import com.ryan.horsegod.services.StudService;

@Controller
public class StudControl {
	private final StudService studServ;
	private final BroodmareService broodServ;
	public Node head;
	public Node tail;
	double height = 6.4d;
	double weight = 12.01d;
	double speed = 31.01d;
	double gait = 4.003d;
	double endurance = 9.0d;
	
	public StudControl(StudService studServ, BroodmareService broodServ) {
		this.studServ = studServ;
		this.broodServ = broodServ;
	}

	@RequestMapping(value="/studify", method=RequestMethod.PUT)
	public String studCreator(@Valid @ModelAttribute("stud") Stud s, BindingResult result) {
		studServ.createStud(s);
		return "redirect:/home";
	}
	
	@RequestMapping("/allstuds")
	public String allStuds(@Valid@ModelAttribute("stud") Stud stud, BindingResult result, Model model) {
		model.addAttribute("allStuds", studServ.allStuds());
		return "/horse/stud/studstock.jsp";
	}
	
	@RequestMapping("/studinfo/{id}")
	public String studInfo(@Valid@ModelAttribute("stud") Stud stud, BindingResult result, @PathVariable(value="id") UUID id, Model model) {
		model.addAttribute("stud", studServ.findStudById(id));
		studServ.findStudById(id);
		return "/horse/stud/studinfo.jsp";
	}
	
	@RequestMapping("/findbrood/{id}")
	public String findBroodForStud(@ModelAttribute("stud") Stud stud, @ModelAttribute("mare") Mare mare, BindingResult result, @PathVariable(value="id") UUID id, Model model) {
		model.addAttribute("stud", studServ.findStudById(id));
		model.addAttribute("allBroods", broodServ.allBroods());
		return "/horse/studfarm/findmare.jsp";
	}
}
