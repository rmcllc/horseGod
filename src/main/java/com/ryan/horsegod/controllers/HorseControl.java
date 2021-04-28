package com.ryan.horsegod.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryan.horsegod.models.Mare;
import com.ryan.horsegod.models.Stud;
import com.ryan.horsegod.nodes.Node;
import com.ryan.horsegod.services.FoalService;
import com.ryan.horsegod.services.MareService;
import com.ryan.horsegod.services.StudService;
import com.ryan.horsegod.services.UserService;

@Controller
public class HorseControl {
	private MareService mareServ;
	private StudService studServ;
	private FoalService foalServ;
	private UserService userServ;
	public Node head;
	public Node head2;
	public Node tail;
	public Node tail2;
	double mareHeight = 0.0d;
	double mareWeight = 0.0d;
	double mareSpeed = 0.0d;
	double mareGait = 0.0d;
	double mareEndurance = 0.0d;
	double foalHeight = 0.0d;
	double foalWeight = 0.0d;
	double foalSpeed = 0.0d;
	double foalGait = 0.0d;
	double foalEndurance = 0.0d;
	double seedHeight = 0.0d;
	double seedWeight = 0.0d;
	double seedSpeed = 0.0d;
	double seedGait = 0.0d;
	double seedEndurance = 0.0d;
	
	public HorseControl(MareService mareServ, StudService studServ, FoalService foalServ, UserService userServ) {
		this.mareServ = mareServ;
		this.studServ = studServ;
		this.foalServ = foalServ;
		this.userServ = userServ;
		this.head = null;
		this.tail = null;
		this.head2 = null;
		this.tail2 = null;
	}
	
//	@RequestMapping("/home")
//	public String home(@ModelAttribute("stud") Stud stud, @ModelAttribute("mare") Mare mare, Model model) {
//		model.addAttribute("allStuds", studServ.allStuds());
//		model.addAttribute("allMares", mareServ.allMares());
//		model.addAttribute("allFoals", foalServ.allFoals());
//		return "/horse/main/stable.jsp";
//	}
	
	@RequestMapping("/horsegod")
	public String horseGod(@ModelAttribute("stud") Stud s, @ModelAttribute("mare") Mare m, Model model, Principal principal) {
		String username = principal.getName();
		model.addAttribute("currentUser", userServ.findByUsername(username));
		model.addAttribute("allStuds", studServ.allStuds());
		model.addAttribute("allMares", mareServ.allMares());
		model.addAttribute("allFoals", foalServ.allFoals());
		return "/horse/main/horse.jsp";
	}
	
	
//	public void mare(Node newNode) {
//		if(this.head == null) {
//			this.head = newNode;
//			this.tail = newNode;
//		}
//		Node lastNode = this.tail;
//		lastNode.next = newNode;
//		newNode.previous = lastNode;
//		this.tail = newNode;
//	}
//	
//	public void stud(Node newNode2) {
//		if(this.head2 == null) {
//			this.head2 = newNode2;
//			this.tail2 = newNode2;
//			return;
//		}
//		Node lastNode2 = this.tail2;
//		lastNode2.next = newNode2;
//		newNode2.previous = lastNode2;
//		this.tail2 = newNode2;
//	}
//	
//	@RequestMapping(value="/fertilize", method=RequestMethod.POST)
//	public String loadMare(@Valid @ModelAttribute("mare") Mare mare, BindingResult mareResult) {
//		Node current = this.head;
//		int counter = 0;
//		while(current != null) {
//			counter++;
//			if(counter == 1) {
//				this.mareHeight = current.value;
//			}
//			if(counter == 2) {
//				this.mareWeight = current.value;
//			}
//			if(counter == 3) {
//				this.mareSpeed = current.value;
//			}
//			if(counter == 4) {
//				this.mareGait = current.value;
//			}
//			if(counter == 5) {
//				this.mareEndurance = current.value;
//			}
//			current = current.next;
//		}
//		return "redirect;/home";
//	}
//	
//	@RequestMapping(value="/horsify", method=RequestMethod.POST)
//	public String loadStud(@Valid @ModelAttribute("newStud") Stud stud, BindingResult studResult) {
//		double value = 0.0;
//		int counter2 = 0;
//		ArrayList<Double> seed = new ArrayList<Double> ();
//		while(counter2 < 5) {
//			counter2++;
//			if(counter2 == 1) {
//				this.seedHeight = ((5.0d + (double) (Math.random() * 1.25)));
//				value = this.seedHeight;
//				seed.add(value);
//			}
//			if(counter2 == 2) {
//				this.seedWeight = ((8.0d + (double) (Math.random() * 2.75)));
//				value = this.seedWeight;
//				seed.add(value);
//			}
//			if(counter2 == 3) {
//				this.seedSpeed = ((28.0d + (double) (Math.random() * 1.5)));
//				value = this.seedSpeed;
//				seed.add(value);
//			}
//			if(counter2 == 4) {
//				this.seedGait = ((4.001d + (double) (Math.random() * 1.25)));
//				value = this.seedGait;
//				seed.add(value);
//			}
//			if(counter2 == 5) {
//				this.seedEndurance = ((6.0d + (double) (Math.random() * 2.5)));
//				value = this.seedEndurance;
//				seed.add(value);
//			}
//		}
//		System.out.println("*****Height: " + this.foalHeight);
//		System.out.println("*****Weight: " + this.foalWeight);
//		System.out.println("*****Speed: " + this.foalSpeed);
//		System.out.println("*****Gait: " + this.foalGait);
//		System.out.println("*****Endurance: " + this.foalEndurance);
//		System.out.println("*****************Seed: " + seed);
//		createHorse(seed);
//		return "redirect:/home";
//	}
//	
//	public void createHorse(ArrayList<Double> foal) {
//		ArrayList<Double> newFoal = new ArrayList<Double> ();
//		for(int i = 0; i < foal.size(); i++) {
//			double value = foal.get(i);
//			double finalValue = 0.0d;
//			double buff = 0.0d;
//			double finalBuff = 0.0d;
//			double buffMult = 1.009d;
//			double deBuff = 0.0d;
//			double deBuffMult = 0.991d;
//			double currentVal = value;
//			int counter = 1;
//			int counter2 = 1;
//			if(buff != 0.0d | deBuff != 0.0d) {
//				break;
//			} else {
//				while(counter <= 10) {
//					if(((1 + (int) (Math.random() * 100)) % (2)) == 0) {
//
//						buff = buff + ((currentVal*buffMult)-(currentVal));
//						currentVal = value+buff;
//					} else {
//					}
//					counter++;
//				while(counter2 <= 10) {
//					if(((1 + (int) (Math.random() * 100)) % (2)) == 0) {
//
//						deBuff = deBuff + ((currentVal*deBuffMult)-(currentVal));
//						currentVal = value+(deBuff);
//					} else {
//						
//					}
//					counter2++;
//				}
//
//				finalBuff = buff+deBuff;
//				finalValue = value + finalBuff;
//				}
//			newFoal.add(finalValue);
//			buff = 0.0;
//			deBuff = 0.0;
//			}	
//			}
//		receiveEgg(newFoal);
//	}
//	
//	public void receiveEgg(ArrayList<Double> seed) {
//		ArrayList<Double> vOneEgg = new ArrayList<Double> ();
//		for(int i = 0; i < seed.size(); i++) {
//			int counter = 1;
//			double currentVal = seed.get(i);
//			while(counter <= 3) {
//				counter++;
//				if(((1 + (int) (Math.random() * 100)) % (2)) == 0) {
//					currentVal = (currentVal+(currentVal * .0175d));
//				} else {
//					currentVal = ((currentVal)-((currentVal) * .0105d));
//				}
//			}
//			vOneEgg.add(currentVal);
//		}
//		System.out.println("Altered Egg:  " + vOneEgg);
//		transfer(vOneEgg);
//	}
//	
//	
//	public void transfer(ArrayList<Double> egg) {
//		@Valid Double value;	
//		for(int i = 0; i < egg.size(); i++) {
//			value = egg.get(i);
//			System.out.println("Current Egg Value: " + value + "************************");
//			}
//	}
	
//	@RequestMapping(value="/marenheir", method=RequestMethod.PUT)
//	public String mareCreator(@ModelAttribute("newMare") Mare m) {
//		mareServ.createMare(m);
//		return "redirect:/home";
//	}
//	@RequestMapping(value="/studify", method=RequestMethod.PUT)
//	public String studCreator(@ModelAttribute("stud") Stud s) {
//		studServ.createStud(s);
//		return "redirect:/home";
//	}
}
