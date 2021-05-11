package com.ryan.horsegod.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryan.horsegod.models.Mare;
import com.ryan.horsegod.models.Stallion;
import com.ryan.horsegod.models.User;
import com.ryan.horsegod.services.BroodmareService;
import com.ryan.horsegod.services.MareService;
import com.ryan.horsegod.services.StallionService;
import com.ryan.horsegod.services.StudService;
import com.ryan.horsegod.services.UserService;
import com.ryan.horsegod.validators.UserValidator;

@Controller
public class UserControl {
	private UserService userServ;
	private UserValidator userVal;
	private MareService mareServ;
	private StudService studServ;
	private StallionService stallServ;
	private BroodmareService broodServ;
	
	
	public UserControl(StallionService stallServ, StudService studServ, UserService userServ, UserValidator userVal, MareService mareServ, BroodmareService broodServ) {
		this.userServ = userServ;
		this.userVal = userVal;
		this.mareServ = mareServ;
		this.stallServ = stallServ;
		this.studServ = studServ;
		this.broodServ = broodServ;
	}
	
	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user, BindingResult result) {
		return "/horse/logreg/logreg.jsp";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, @ModelAttribute("email") String email, Model model, HttpSession session) {
		userVal.validate(user, result);
		if(result.hasErrors()) {
			return "/horse/logreg/logreg.jsp";
		}
		userServ.saveUserWithAdminRole(user);
		return "redirect:/login";
	}
	
	@RequestMapping("/admin")
	public String adminPage(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userServ.findByUsername(username));
		model.addAttribute("allUsers", userServ.allUsers());
		return "/horse/admin/admin.jsp";
	}
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("user") User user, BindingResult result, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		if(error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if(logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		return "/horse/logreg/logreg.jsp";
	}
	
	@RequestMapping(value = {"/", "/home"})
	public String home(Principal principal, Model model) {
		String username = principal.getName();
		User user = userServ.findByUsername(username);
		if(user==null) {
			return "redirect:/registration";
		} else {
			model.addAttribute("currentUser", userServ.findByUsername(username));
			model.addAttribute("allStuds", studServ.allOwnedStuds(user.getId()));
			model.addAttribute("allBroods", broodServ.allOwnedBroods(user.getId()));
			List<Stallion> stallion = stallServ.allOwnedStallions(user.getId());
			List<Stallion> notStud = new ArrayList<Stallion>();
			for(int i=0; i<stallion.size(); i++) {
				System.out.println("Stallion Array Size***************************************************************************: " + stallion.size());
				if(stallion.get(i).getStudId() == null) {
					System.out.println("STUD ID ??????????????????????????????????????????????????????????????: " + stallion.get(i).getStudId());
					notStud.add(stallion.get(i));
				}
			}
			List<Mare> mare = mareServ.allOwnedMares(user.getId());
			List<Mare> notBrood = new ArrayList<Mare>();
			for(int i=0; i<mare.size(); i++) {
				if(mare.get(i).getBroodmareId() == null) {
					notBrood.add(mare.get(i));
				}
			}
			model.addAttribute("allStalls", notStud);
			model.addAttribute("allMares", notBrood);
			
			return "/horse/main/stable.jsp";
		}
	}
			
	@RequestMapping("/edituser/{id}")
	public String editUser(@PathVariable(value="id") UUID id, Model model, HttpSession session) {
		User user = userServ.findUser(id);
		model.addAttribute("user", user);
		return "/horse/admin/edituser.jsp";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public String editUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/horse/admin/edituser.jsp";
		} else {
			userServ.updateUser(user);
			return "redirect:/admin";
		}
	}
	
	@RequestMapping(value="/destroy/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") UUID id) {
		userServ.deleteUser(id);
		return "redirect:/home";
	}
}
