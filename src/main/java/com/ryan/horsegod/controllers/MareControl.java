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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ryan.horsegod.models.Broodmare;
import com.ryan.horsegod.models.Colt;
import com.ryan.horsegod.models.Dam;
import com.ryan.horsegod.models.Filly;
import com.ryan.horsegod.models.Foal;
import com.ryan.horsegod.models.Mare;
import com.ryan.horsegod.models.Sire;
import com.ryan.horsegod.models.Stallion;
import com.ryan.horsegod.models.Stud;
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
	
	@RequestMapping("/confirm/{studId}/{mareId}")
	public String confirmPairing(@PathVariable(value="studId") UUID studId, @PathVariable(value="mareId") UUID mareId, @ModelAttribute("stud") Stud stud, @ModelAttribute Mare mare, BindingResult result, Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentUser", userServ.findByUsername(username));
		model.addAttribute("stud", studServ.findStudById(studId));
		model.addAttribute("mare", mareServ.findMare(mareId));
		System.out.println("MARE CONTROL STUD ID &&&&&&&&&&&&&&&&&&&&&&&& : " + studId);
		model.addAttribute("allMares", mareServ.allMares());
		return "/horse/studfarm/matingbarn.jsp";
	}
	
	@RequestMapping("/mareinfo/{id}")
	public String mareInfo(@PathVariable(value="id") UUID id, Model model) {
		model.addAttribute("mare", mareServ.findMare(id));
		return "/horse/mare/mareinfo.jsp";
	}
	
	@RequestMapping(value="/hayroll/{studId}/{broodmareId}", method=RequestMethod.POST)
	public String imPreg(@Valid @PathVariable(value="studId") UUID studId, @PathVariable(value="broodMareId") UUID broodId, @ModelAttribute("broodmare") Broodmare broodmare , @ModelAttribute("stud") Stud stud, @ModelAttribute("dam") Dam dam, @ModelAttribute("sire") Sire sire, @ModelAttribute("foal") Foal foal, BindingResult result, Principal principal, Model model, HttpSession session) {
		model.addAttribute("stud", studServ.findStudById(studId));
		model.addAttribute("brood", broodServ.findBroodById(broodId));
		stud = studServ.findStudById(studId);
		broodmare = broodServ.findBroodById(broodId);
		double studHt = stud.getHeight();
		double studWt = stud.getWeight();
		double studSp = stud.getSpeed();
		double studGt = stud.getGait();
		double studEn = stud.getEndurance();
		double broodHt = broodmare.getHeight();
		double broodWt = broodmare.getWeight();
		double broodSp = broodmare.getSpeed();
		double broodGt = broodmare.getGait();
		double broodEn = broodmare.getEndurance();
		double seedHt = (studHt+broodHt)/2;
		double seedWt = (studWt+broodWt)/2;
		double seedSp = (studSp+broodSp)/2;
		double seedGt = (studGt+broodGt)/2;
		double seedEn = (studEn+broodEn)/2;
		double buff = 0.0d;
		double buffMult = 1.009d;
		double deBuff = 0.0d;
		double deBuffMult = 0.991d;
		int counter = 1;
		int cycle = 1;
		int key = 1;
		
		//create sire ----------------------------------------------------------------------------------------------------------------------------------------------
		
		String username = principal.getName();
		User user = userServ.findByUsername(username);
		sire.setStud(stud);
		sire.setUser(user);
		sireServ.createSire(sire);
		
		//create dam -----------------------------------------------------------------------------------------------------------------------------------------------
		
		dam.setBroodmare(broodmare);
		dam.setUser(user);
		damServ.createDam(dam);
		
		//Create Foal-----------------------------------------------------------------------------------------------------------------------------------------------
		
		if(result.hasErrors()) {
			return "error";
		} else {
			while(counter <= 5 && cycle == 1) {
			System.out.println("Counter Mare Control $$$$$$$$$$$$$$$$$$$$$$$$: " + counter);
			int roll = 1;
			while(roll <= 2) {
				System.out.println("Roll Mare Control $$$$$$$$$$$$$$$$$$$$$$$$: " + roll);
				roll++;
				if(counter==1) {
					System.out.println("SEED HT!!!!!!!!!!!!!!!!!!!: " + seedHt);
					seedHt = (((seedHt) + (double) (Math.random() * 1.25)));
					System.out.println("SEED HT!!!!!!!!!!!!!!!!!!!: " + seedHt);
					seedHt = (((seedHt) - (double) (Math.random() * 1.25)));
					System.out.println("SEED HT!!!!!!!!!!!!!!!!!!!: " + seedHt);
					foal.setHeight(seedHt);
				}
				if(counter==2) {
					System.out.println("SEED WT!!!!!!!!!!!!!!!!!!!: " + seedWt);
					seedWt = ((seedWt + (double) (Math.random() * 2.75)));
					System.out.println("SEED WT!!!!!!!!!!!!!!!!!!!: " + seedWt);
					seedWt = ((seedWt - (double) (Math.random() * 2.75)));
					System.out.println("SEED WT!!!!!!!!!!!!!!!!!!!: " + seedWt);
					foal.setWeight(seedWt);
				}
				if(counter==3) {
					System.out.println("SEED SP!!!!!!!!!!!!!!!!!!!: " + seedSp);
					seedSp = ((seedSp + (double) (Math.random() * 1.5)));
					System.out.println("SEED SP!!!!!!!!!!!!!!!!!!!: " + seedSp);
					seedSp = ((seedSp - (double) (Math.random() * 1.5)));
					System.out.println("SEED SP!!!!!!!!!!!!!!!!!!!: " + seedSp);
					foal.setSpeed(seedSp);
				}
				if(counter==4) {
					System.out.println("SEED GT!!!!!!!!!!!!!!!!!!!: " + seedGt);
					seedGt = ((seedGt + (double) (Math.random() * 1.25)));
					System.out.println("SEED GT!!!!!!!!!!!!!!!!!!!: " + seedGt);
					seedGt = ((seedGt - (double) (Math.random() * 1.25)));
					System.out.println("SEED GT!!!!!!!!!!!!!!!!!!!: " + seedGt);
					foal.setGait(seedGt);
				}
				if(counter==5) {
					System.out.println("SEED EN!!!!!!!!!!!!!!!!!!!: " + seedEn);
					seedEn = ((seedEn + (double) (Math.random() * 2.5)));
					System.out.println("SEED EN!!!!!!!!!!!!!!!!!!!: " + seedEn);
					seedEn = ((seedEn - (double) (Math.random() * 2.5)));
					System.out.println("SEED EN!!!!!!!!!!!!!!!!!!!: " + seedEn);
					foal.setEndurance(seedEn);
				}
			}
			counter++;
			}
			counter = 1;
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("CYCLE(inside) Mare Control $$$$$$$$$$$$$$$$$$$$$$$$: " + cycle);
			cycle++;
			foal.setDam(dam);
			foal.setSire(sire);
			System.out.println("Counter Mare Control $$$$$$$$$$$$$$$$$$$$$$$$: " + counter);
		}
		System.out.println("CYCLE(outside) Mare Control $$$$$$$$$$$$$$$$$$$$$$$$: " + cycle);
		System.out.println("FOAL SEED HEIGHT -------------------------------------------------------------------------------------------------------------------- : " + foal.getHeight());
		System.out.println("FOAL SEED WEIGHT -------------------------------------------------------------------------------------------------------------------- : " + foal.getWeight());
		System.out.println("FOAL SEED SPEED -------------------------------------------------------------------------------------------------------------------- : " + foal.getSpeed());
		System.out.println("FOAL SEED GAIT -------------------------------------------------------------------------------------------------------------------- : " + foal.getGait());
		System.out.println("FOAL SEED ENDURANCE -------------------------------------------------------------------------------------------------------------------- : " + foal.getEndurance());
		
		//Foal Buff Cycle----------------------------------------------------------------------------------------------------------------------------------------------------
		
		while(counter <= 5 && cycle == 2) {
			System.out.println(" ");
			System.out.println("");
			System.out.println("COUNTER ############################################################################################## : " + counter);
			int roll = 1;
			while(roll<=10 && key<=5) {
				System.out.println("KEY: " + key);
				System.out.println("ROLL %%%%: " + roll);
				roll++;
				if(((1 + (int) (Math.random() * 100)) % (2)) == 0) {
					if(key==1) {
						buff = buff + ((foal.getHeight()*buffMult)-(foal.getHeight()));
						System.out.println("FOAL BUFF%%%%%%%%%%%%%%%%%%%%%%%: " + buff + "***************** Key: " + key);
						foal.setHeight((foal.getHeight())+(buff));
						System.out.println("Foal Height________________________________________: " + foal.getHeight());
					}
					if(key==2) {
						buff = buff + ((foal.getWeight()*buffMult)-(foal.getWeight()));
						System.out.println("FOAL BUFF%%%%%%%%%%%%%%%%%%%%%%%: " + buff + "***************** Key: " + key);
						foal.setWeight((foal.getWeight())+(buff));
						System.out.println("Foal Weight________________________________________: " + foal.getWeight());
					}
					if(key==3) {
						System.out.println("Foal Speed________________________________________: " + foal.getSpeed());
						buff = buff + ((foal.getSpeed()*buffMult)-(foal.getSpeed()));
						System.out.println("FOAL BUFF%%%%%%%%%%%%%%%%%%%%%%%: " + buff + "***************** Key: " + key);
						foal.setSpeed((foal.getSpeed())+(buff));
						System.out.println("Foal Speed________________________________________: " + foal.getSpeed());
					}
					if(key==4) {
						buff = buff + ((foal.getGait()*buffMult)-(foal.getGait()));
						System.out.println("FOAL BUFF%%%%%%%%%%%%%%%%%%%%%%%: " + buff + "***************** Key: " + key);
						foal.setGait((foal.getGait())+(buff));
						System.out.println("Foal Gait________________________________________: " + foal.getGait());
					}
					if(key==5) {
						buff = buff + (((foal.getEndurance())*(buffMult))-(foal.getEndurance()));
						System.out.println("FOAL BUFF%%%%%%%%%%%%%%%%%%%%%%%: " + buff + "***************** Key: " + key);
						foal.setEndurance((foal.getEndurance())+(buff));
						System.out.println("Foal Endurance________________________________________: " + foal.getEndurance());
					}
				}
				System.out.println("KEY: " + key);
				System.out.println(" ");
				System.out.println(" ");
				buff=0.0d;
			}
			counter++;
			key++;
			roll=1;
			System.out.println("KEY: " + key);
				
		}
		cycle++;
		counter=1;
		key = 1;
		
		//Foal Debuff Cycle-------------------------------------------------------------------------------------------------------------------------------------------------
		
		while(counter<=5 && cycle==3) {
			System.out.println(" ");
			System.out.println("");
			System.out.println("COUNTER ############################################################################################## : " + counter);
			int roll = 1;
			while(roll<=10 && key<=5) {
				System.out.println("KEY: " + key);
				System.out.println("ROLL %%%%: " + roll);
				roll++;
				if(((1 + (int) (Math.random() * 100)) % (2)) == 0) {
					if(key==1) {
						deBuff = deBuff + ((foal.getHeight()*deBuffMult)-(foal.getHeight()));
						System.out.println("FOAL DEBuff%%%%%%%%%%%%%%%%%%%%%%%: " + deBuff + "***************** Key: " + key);
						foal.setHeight((foal.getHeight())+(deBuff));
						System.out.println("Foal Height________________________________________: " + foal.getHeight());
					}
					if(key==2) {
						deBuff = deBuff + ((foal.getWeight()*deBuffMult)-(foal.getWeight()));
						System.out.println("FOAL DEBuff%%%%%%%%%%%%%%%%%%%%%%%: " + deBuff + "***************** Key: " + key);
						foal.setWeight((foal.getWeight())+(deBuff));
						System.out.println("Foal Weight________________________________________: " + foal.getWeight());
					}
					if(key==3) {
						deBuff = deBuff + ((foal.getSpeed()*deBuffMult)-(foal.getSpeed()));
						System.out.println("FOAL DEBuff%%%%%%%%%%%%%%%%%%%%%%%: " + deBuff + "***************** Key: " + key);
						foal.setSpeed((foal.getSpeed())+(deBuff));
						System.out.println("Foal Speed________________________________________: " + foal.getSpeed());
					}
					if(key==4) {
						deBuff = deBuff + ((foal.getGait()*deBuffMult)-(foal.getGait()));
						System.out.println("FOAL DEBuff%%%%%%%%%%%%%%%%%%%%%%%: " + deBuff + "***************** Key: " + key);
						foal.setGait((foal.getGait())+(deBuff));
						System.out.println("Foal Gait________________________________________: " + foal.getGait());
					}
					if(key==5) {
						deBuff = deBuff + ((foal.getEndurance()*deBuffMult)-(foal.getEndurance()));
						System.out.println("FOAL DEBuff%%%%%%%%%%%%%%%%%%%%%%%: " + deBuff + "***************** Key: " + key);
						foal.setEndurance((foal.getEndurance())+(deBuff));
						System.out.println("Foal Endurance________________________________________: " + foal.getEndurance());
					}
				}
				deBuff=0.0d;
			}
			counter++;
			key++;
			roll=1;
		}
		foal.setUser(user);
		foalServ.createFoal(foal);
		cycle++;
		counter=1;
		key=1;
		
		//Determine Gender Colt/Filly----------------------------------------------------------------------------------------------------------------------------------------
		
		boolean isColt = true;
		double foalHeight = foal.getHeight();
		double foalWeight = foal.getWeight();
		double foalSpeed = foal.getSpeed();
		double foalGait = foal.getGait();
		double foalEndurance = foal.getEndurance();
		while(counter<=5 && cycle==4) {
			if(key==1) {
				System.out.println("ISCOLT BOOLEAN Start -------------------------------------------------------------------->: " + isColt);
				if(foalHeight <= 6.05d) {
					isColt = false;
					System.out.println("ISCOLT BOOLEAN after height-------------------------------------------------------------------->: " + isColt);
				}
			}
			if(key==3) {
				System.out.println("ISCOLT BOOLEAN before speed-------------------------------------------------------------------->: " + isColt);
				if(foalSpeed >= 29.01d) {
					isColt = true;
					System.out.println("ISCOLT BOOLEAN after speed-------------------------------------------------------------------->: " + isColt);
					System.out.println("FOAL SPEED -------------------------------------->: " + foalSpeed);
				}
			}
			counter++;
			System.out.println("KEY--------------------------------------------->: " + key);
			key++;
			System.out.println("ISCOLT BOOLEAN END-------------------------------------------------------------------->: " + isColt);
		}
		if(isColt == true) {
			Colt colt = new Colt();
			colt.setHeight(foalHeight);
			colt.setWeight(foalWeight);
			colt.setSpeed(foalSpeed);
			colt.setGait(foalGait);
			colt.setEndurance(foalEndurance);
			colt.setFoal(foal);
			colt.setUser(user);
			coltServ.createColt(colt);
			Stallion stallion = new Stallion();
			stallion.setHeight(foalHeight);
			stallion.setWeight(foalWeight);
			stallion.setSpeed(foalSpeed);
			stallion.setGait(foalGait);
			stallion.setEndurance(foalEndurance);
			stallion.setColt(colt);
			stallion.setUser(user);
			stallServ.create(stallion);
		} else {
			Filly filly = new Filly();
			filly.setHeight(foalHeight);
			filly.setWeight(foalWeight);
			filly.setSpeed(foalSpeed);
			filly.setGait(foalGait);
			filly.setEndurance(foalEndurance);
			filly.setFoal(foal);
			filly.setUser(user);
			fillyServ.createFilly(filly);
			Mare newMare = new Mare();
			newMare.setHeight(foalHeight);
			newMare.setWeight(foalWeight);
			newMare.setSpeed(foalSpeed);
			newMare.setGait(foalGait);
			newMare.setEndurance(foalEndurance);
			newMare.setFilly(filly);
			newMare.setUser(user);
			mareServ.createMare(newMare);
		}
		return "/horse/foal/newfoal.jsp";
	}
}
			
