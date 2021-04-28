package com.ryan.horsegod.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Foal;
import com.ryan.horsegod.repositories.FoalRepository;

@Service
public class FoalService {
	private final FoalRepository foalRepo;
	
	public FoalService(FoalRepository foalRepo) {
		this.foalRepo = foalRepo;
	}
	
	public void createFoal(Foal f) {
		foalRepo.save(f);
	}
	
	public Foal updateFoal(UUID foalId, Double height, Double weight, Double speed, Double gait, Double endurance) {
		Optional<Foal> optionalFoal = foalRepo.findById(foalId);
		if(optionalFoal.isPresent()) {
			Foal editFoal = optionalFoal.get();
			editFoal.setHeight(height);
			editFoal.setWeight(weight);
			editFoal.setSpeed(speed);
			editFoal.setGait(gait);
			editFoal.setEndurance(endurance);
			foalRepo.save(editFoal);
		} else {
			return null;
		}
		return null;
	}
	
	public List<Foal> allFoals() {
		return (List<Foal>) foalRepo.findAll();
	}
	
	public Foal findFoal(UUID id) {
		Optional<Foal> optionalFoal = foalRepo.findById(id);
		if(optionalFoal.isPresent()) {
			return optionalFoal.get();
		} else {
			return null;
		}
	}
	
	public List<Foal> allOwnedFoals(UUID id) {
		return (List<Foal>) foalRepo.findByUserId(id);
	}
}
