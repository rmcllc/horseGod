package com.ryan.horsegod.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Stud;
import com.ryan.horsegod.repositories.StudRepository;

@Service
public class StudService {
	private final StudRepository studRepo;
	
	public StudService(StudRepository studRepo) {
		this.studRepo = studRepo;
	}
	
	public void createStud(Stud s) {
		studRepo.save(s);
	}
	
	public Stud updateStud(UUID id, Double height, Double weight, Double speed, Double gait, Double endurance) {
		Optional<Stud> optionalStud = studRepo.findById(id);
		if(optionalStud.isPresent()) {
			Stud editStud = optionalStud.get();
			editStud.setHeight(height);
			editStud.setWeight(weight);
			editStud.setSpeed(speed);
			editStud.setGait(gait);
			editStud.setEndurance(endurance);
			studRepo.save(editStud);
		} else {
			return null;
		}
		return null;
	}
	
	public List<Stud> allStuds() {
		return (List<Stud>) studRepo.findAll();
	}
	
	public Stud findStudById(UUID studId) {
		Optional<Stud> optionalStud = studRepo.findById(studId);
		if(optionalStud.isPresent()) {
			return optionalStud.get();
		} else {
			return null;
		}
	}
	
	public List<Stud> allOwnedStuds(UUID id) {
		return (List<Stud>) studRepo.findByUserId(id);
	}
}




























