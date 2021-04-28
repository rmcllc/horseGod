package com.ryan.horsegod.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Stallion;
import com.ryan.horsegod.repositories.StallionRepository;

@Service
public class StallionService {
	private StallionRepository stallRepo;
	
	public StallionService(StallionRepository stallRepo) {
		this.stallRepo = stallRepo;
	}
	public void create(Stallion s) {
		stallRepo.save(s);
	}
	public Stallion findStallionById(UUID id) {
		Optional<Stallion> optionalStallion = stallRepo.findById(id);
		if(optionalStallion.isPresent()) {
			return optionalStallion.get();
		} else {
			return null;
		}
	}
	public List<Stallion> allStallions() {
		return (List<Stallion>) stallRepo.findAll();
	}
	public Stallion updateStallion(UUID id, Double height, Double weight, Double speed, Double gait, Double endurance, UUID studId) {
		Optional<Stallion> optionalStallion = stallRepo.findById(id);
			if(optionalStallion.isPresent()) {
				Stallion editStallion = optionalStallion.get();
				editStallion.setHeight(height);
				editStallion.setWeight(weight);
				editStallion.setSpeed(speed);
				editStallion.setGait(gait);
				editStallion.setEndurance(endurance);
				editStallion.setStudId(studId);
				stallRepo.save(editStallion);
			}
			return null;
	}
	public List<Stallion> allOwnedStallions(UUID id) {
		return (List<Stallion>) stallRepo.findByUserId(id);
	}

}
