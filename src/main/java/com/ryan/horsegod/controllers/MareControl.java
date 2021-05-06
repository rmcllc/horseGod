package com.ryan.horsegod.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	private StudService studServ;
	private DamService damServ;
	private SireService sireServ;
	private FoalService foalServ;
	private ColtService coltServ;
	private FillyService fillyServ;
	private StallionService stallServ;
	
	public MareControl(UserService userServ, StallionService stallServ, MareService mareServ, StudService studServ, BroodmareService broodServ, DamService damServ, SireService sireServ, FoalService foalServ, ColtService coltServ, FillyService fillyServ) {
		this.mareServ = mareServ;
		this.studServ = studServ;
		this.damServ = damServ;
		this.sireServ = sireServ;
		this.foalServ = foalServ;
		this.userServ = userServ;
		this.coltServ = coltServ;
		this.fillyServ = fillyServ;
		this.stallServ = stallServ;
		this.broodServ = broodServ;
	}
	
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
	
	
}
			
