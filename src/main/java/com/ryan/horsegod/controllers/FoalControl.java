package com.ryan.horsegod.controllers;

import java.util.UUID;

import org.springframework.stereotype.Controller;

import com.ryan.horsegod.services.ColtService;
import com.ryan.horsegod.services.FillyService;
import com.ryan.horsegod.services.FoalService;
import com.ryan.horsegod.services.MareService;
import com.ryan.horsegod.services.StudService;

@Controller
public class FoalControl {
//	private FoalService foalServ;
//	private StudService studServ;
//	private MareService mareServ;
//	public Node head;
//	public Node2 head2;
//	public Node tail;
//	public Node2 tail2;
	UUID damId;
	UUID sireId;
	UUID foalId;
	Double damHeight;
	Double damWeight;
	Double damSpeed;
	Double damGait;
	Double damEndurance;
	Double sireHeight;
	Double sireWeight;
	Double sireSpeed;
	Double sireGait;
	Double sireEndurance;
	Double foalHeight;
	Double foalWeight;
	Double foalSpeed;
	Double foalGait;
	Double foalEndurance;
	
	
	public FoalControl(FoalService foalServ, StudService studServ, MareService mareServ, ColtService coltServ, FillyService fillyServ) {
//		this.foalServ = foalServ;
//		this.studServ = studServ;
//		this.mareServ = mareServ;
//		this.head = null;
//		this.tail = null;
//		this.head2 = null;
//		this.tail2 = null;
	}
	
//	public void mare(Node newNode) {
//		if(head == null) {
//			this.head = newNode;
//			this.tail = newNode;
//		}
//		Node lastNode = this.tail;
//		lastNode.next = newNode;
//		newNode.previous = lastNode;
//		this.tail = newNode;
//	}
//	
//	public void stud(Node2 newNode) {
//		if(this.head2 == null) {
//			this.head2 = newNode;
//			this.tail2 = newNode;
//			return;
//		}
//		Node2 lastNode2 = this.tail2;
//		lastNode2.next = newNode;
//		newNode.previous = lastNode2;
//		this.tail2 = newNode;
//	}
	
//	@RequestMapping(value = "/create/{stud_id}/{mare_id}", method = RequestMethod.POST)
//	public String makeFoal(@Valid @ModelAttribute("foal") Foal foal, BindingResult result, @PathVariable(name="stud_id") UUID id, @PathVariable(name="mare_id") UUID idx, Model model) {
//		
//		Mare currentMare = new Mare();
//		currentMare = mareServ.findMare(idx);
//		this.damHeight = currentMare.getHeight();
//		this.damWeight = currentMare.getWeight();
//		this.damSpeed = currentMare.getSpeed();
//		this.damGait = currentMare.getGait();
//		this.damEndurance = currentMare.getEndurance();
//
//
//
//		Stud currentStud = new Stud();
//		currentStud = studServ.findStud(idx);
//		this.sireHeight = currentStud.getHeight();
//		this.sireWeight = currentStud.getWeight();
//		this.sireSpeed = currentStud.getSpeed();
//		this.sireGait = currentStud.getGait();
//		this.sireEndurance = currentStud.getEndurance();
//
//		
//		Foal newFoal = new Foal();
//		
//		int counter3 = 0;
//		while(counter3 < 5) {
//			counter3++;
//			if(counter3 == 1) {
//				this.foalHeight = ((5.0d + (double) (Math.random() * 1.25)));
//				newFoal.setHeight(foalHeight);
//				System.out.println("***************************************************Foal1: " + newFoal.getHeight());
//			}
//			if(counter3 == 2) {
//				this.foalWeight = ((8.0d + (double) (Math.random() * 2.75)));
//				newFoal.setWeight(foalWeight);
//				System.out.println("***************************************************Foal1: " + newFoal.getWeight());
//			}
//			if(counter3 == 3) {
//				this.foalSpeed = ((28.0d + (double) (Math.random() * 1.5)));
//				newFoal.setSpeed(foalSpeed);
//				System.out.println("***************************************************Foal1: " + newFoal.getSpeed());
//			}
//			if(counter3 == 4) {
//				this.foalGait = ((4.001d + (double) (Math.random() * 1.25)));
//				newFoal.setGait(foalGait);
//				System.out.println("***************************************************Foal1: " + newFoal.getGait());
//			}
//			if(counter3 == 5) {
//				this.foalEndurance = ((6.0d + (double) (Math.random() * 2.5)));
//				newFoal.setEndurance(foalEndurance);
//				System.out.println("***************************************************Foal1: " + newFoal.getEndurance());
//			}
//		}
//		foalServ.createFoal(newFoal);
//		this.foalId = newFoal.getId();
//		return "redirect:/home";
//	}
//		
		
		

//		int counter = 0;
//		Node current = this.head;
//		while(current != null) {
//			model.addAttribute("Sire", mareServ.findMare(idx));
//			counter++;
//			if(counter == 1) {
//				currentDam.setHeight(current.value);
//				this.damHeight = currentDam.getHeight();
//				System.out.println("***************************************************Dam1: " + damHeight);
//			}
//			if(counter == 2) {
//				currentDam.setWeight(current.value);
//				System.out.println("***************************************************Dam1: " + currentDam.getWeight());
//			}
//			if(counter == 3) {
//				currentDam.setSpeed(current.value);
//				System.out.println("***************************************************Dam1: " + currentDam.getSpeed());
//			}
//			if(counter == 4) {
//				currentDam.setGait(current.value);
//				System.out.println("***************************************************Dam1: " + currentDam.getGait());
//			}
//			if(counter == 5) {
//				currentDam.setEndurance(current.value);
//				System.out.println("***************************************************Dam1: " + currentDam.getEndurance());
//			}
//			current = current.next;
//		}
//		damServ.createDam(currentDam);
//		this.damId = currentDam.getId();
//		int counter2 = 0;
//		Node2 current2 = this.head2;
//		while(current2 != null) {
//			model.addAttribute("stud", studServ.findStud(id));
//			counter2++;
//			if(counter2 == 1) {
//				currentSire.setHeight(current2.value);
//				this.sireHeight = currentSire.getHeight();
//				System.out.println("***************************************************Sire1: " + sireHeight);
//			}
//			if(counter2 == 2) {
//				currentSire.setWeight(current2.value);
//				System.out.println("***************************************************Sire1: " + currentSire.getWeight());
//			}
//			if(counter2 == 3) {
//				currentSire.setSpeed(current2.value);
//				System.out.println("***************************************************Sire1: " + currentSire.getSpeed());
//			}
//			if(counter2 == 4) {
//				currentSire.setGait(current2.value);
//				System.out.println("***************************************************Sire1: " + currentSire.getGait());
//			}
//			if(counter2 == 5) {
//				currentSire.setEndurance(current2.value);
//				System.out.println("***************************************************Sire1: " + currentSire.getEndurance());
//			}
//			current2 = current2.next;
//		}
//		this.sireId = currentSire.getId();
//		sireServ.createSire(currentSire);
//		
	
//	public void createHorse(@ModelAttribute("dam") Dam currentDam) {
//		int cycle = 1;
//		while(cycle <= 5) {
//			double buff = 0.0d;
//			double buffMult = 1.009d;
//			double deBuff = 0.0d;
//			double deBuffMult = 0.991d;
//			int counter = 1;
//			int counter2 = 1;
//			int counter3 = 1;
//			int counter4 = 1;
//			Foal newFoal2 = new Foal();
//			if(buff != 0.0d | deBuff != 0.0d) {
//				break;
//			} else {
//				while(counter <= 10) {
//					if(((1 + (int) (Math.random() * 100)) % (2)) == 0) {
//						counter++;
//						if(counter3 == 1) {
//							buff = buff + ((foalHeight*buffMult)-(foalHeight));
//							foalHeight = foalHeight+buff;
//							System.out.println("********************Foal Height: " + foalHeight);
//						}
//						if(counter3 == 2) {
//							buff = buff + ((foalWeight*buffMult)-(foalWeight));
//							foalWeight = foalWeight+buff;
//							System.out.println("********************Foal Weight: " + foalWeight);
//						}
//						if(counter3 == 3) {
//							buff = buff + ((foalSpeed*buffMult)-(foalSpeed));
//							foalSpeed = foalSpeed+buff;
//							System.out.println("********************Foal Speed: " + foalSpeed);
//						}
//						if(counter3 == 4) {
//							buff = buff + ((foalGait*buffMult)-(foalGait));
//							foalGait = foalGait+buff;
//							System.out.println("********************Foal Gait: " + foalGait);
//						}
//						if(counter3 == 5) {
//							buff = buff + ((foalEndurance*buffMult)-(foalEndurance));
//							foalEndurance = foalEndurance+buff;
//							System.out.println("********************Foal Endurance: " + foalEndurance);
//						}
//						counter3++;
//					}
//				
//				while(counter2 <= 10) {
//					if(((1 + (int) (Math.random() * 100)) % (2)) == 0) {
//						if(counter4 == 1) {
//							deBuff = deBuff + ((foalHeight*deBuffMult)-(foalHeight));
//							foalHeight = foalHeight+deBuff;
//						}
//						if(counter4 == 2) {
//							deBuff = deBuff + ((foalWeight*deBuffMult)-(foalWeight));
//							foalWeight = foalWeight+deBuff;
//						}
//						if(counter4 == 3) {
//							deBuff = deBuff + ((foalSpeed*deBuffMult)-(foalSpeed));
//							foalSpeed = foalSpeed+deBuff;
//						}
//						if(counter4 == 4) {
//							deBuff = deBuff + ((foalGait*deBuffMult)-(foalGait));
//							foalGait = foalGait+deBuff;
//						}
//						if(counter4 == 5) {
//							deBuff = deBuff + ((foalEndurance*deBuffMult)-(foalEndurance));
//							foalEndurance = foalEndurance+deBuff;
//						}
//						counter2++;
//						counter4++;
//					}
//				}
//				newFoal2.setHeight(foalHeight);
//				newFoal2.setWeight(foalWeight);
//				newFoal2.setSpeed(foalSpeed);
//				newFoal2.setGait(foalGait);
//				newFoal2.setEndurance(foalEndurance);
//				}
//				foalServ.updateFoal(foalId, foalHeight, foalWeight, foalSpeed, foalGait, foalEndurance);
//				buff = 0.0;
//				deBuff = 0.0;
//			}
//			cycle++;
//			}
//		receiveEgg();
//	}
//	
//	public void receiveEgg() {
//		Foal newFoal3 = foalServ.findFoal(foalId);
//		int cycle = 1;
//		while(cycle <= 5) {
//			int counter = 1;
//			while(counter <= 3) {
//				if(((1 + (int) (Math.random() * 100)) % (2)) == 0) {
//					if(cycle==1) {
//						foalHeight = (foalHeight+(foalHeight * .0175d));
//					} else {
//						foalHeight = ((foalHeight)-((foalHeight) * .0105d));
//					}
//
//				}
//				counter++;
//			}
//			if(cycle == 1) {
//				newFoal3.setHeight(foalHeight);
//			}
//			if(cycle == 2) {
//				newFoal3.setWeight(foalWeight);
//			}
//			if(cycle == 3) {
//				newFoal3.setSpeed(foalSpeed);
//			}
//			if(cycle == 4) {
//				newFoal3.setGait(foalGait);
//			}
//			if(cycle == 5) {
//				newFoal3.setEndurance(foalEndurance);
//			}
//			cycle++;
//		}
//		foalServ.updateFoal(foalId, foalHeight, foalWeight, foalSpeed, foalGait, foalEndurance);
//		yChrom();
//	}
//	
//	@RequestMapping("/tryy")
//	public String yChrom() {
//		Colt newColt = new Colt();
//		Filly newFilly = new Filly();
//		Foal newFoal = new Foal();
//		boolean pos = false;
//		boolean colt = false;
//		boolean filly = false;
//		 while(pos!=true) {
//			if(this.foalHeight >= 6.0d && this.foalWeight >= 9.6d && this.foalWeight < 13.0d) {
//				newColt.setHeight(this.foalHeight);
//				newColt.setWeight(this.foalWeight);
//				newColt.setSpeed(this.foalSpeed);
//				newColt.setGait(this.foalGait);
//				newColt.setEndurance(this.foalEndurance);
//				pos = true;
//				colt = true;
//			}
//			if(this.foalHeight >= 5.7d && this.foalHeight < 6.0d && this.foalWeight < 12.5d && this.foalWeight > 9.0d) {
//				newFilly.setHeight(this.foalHeight);
//				newFilly.setWeight(this.foalWeight);
//				newFilly.setSpeed(this.foalSpeed);
//				newFilly.setGait(this.foalGait);
//				newFilly.setEndurance(this.foalEndurance);
//				pos = true;
//			} else {
//				return "redirect:/makeFoal/{this.studId}/{this.mareId}";
//
//			}
////			if(colt == true) {
////				coltServ.createColt(newFoal);
////				colt = false;
////			}
////			if(filly == true) {
////				fillyServ.createFilly(newFoal);
////				filly = false;
////			} else {
////				return "redirect:/makeFoal/{this.studId}/{this.mareId}";
////			}
//		}
//		return "/home";
//	}

}
