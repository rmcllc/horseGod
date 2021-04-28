package com.ryan.horsegod.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Broodmare;
import com.ryan.horsegod.repositories.BroodmareRepository;

@Service
public class BroodmareService {
	private BroodmareRepository broodRepo;
	
	public BroodmareService(BroodmareRepository broodRepo) {
		this.broodRepo = broodRepo;
	}
	
	public void create(Broodmare b) {
		broodRepo.save(b);
	}
	
	public Broodmare updateBroodmare(UUID id, Double height, Double weight, Double speed, Double gait, Double endurance) {
		Optional<Broodmare> optionalBrood = broodRepo.findById(id);
		if(optionalBrood.isPresent()) {
			Broodmare editBrood = optionalBrood.get();
			editBrood.setHeight(height);
			editBrood.setWeight(weight);
			editBrood.setSpeed(speed);
			editBrood.setGait(gait);
			editBrood.setEndurance(endurance);
			broodRepo.save(editBrood);
		} else {
			return null;
		}
		return null;
	}
	
	public List<Broodmare> allBroods() {
		return (List<Broodmare>) broodRepo.findAll();
	}
	
	public Broodmare findBroodById(UUID broodId) {
		Optional<Broodmare> optionalBrood = broodRepo.findById(broodId);
		if(optionalBrood.isPresent()) {
			return optionalBrood.get();
		} else {
			return null;
		}
	}
	
	public List<Broodmare> allOwnedBroods(UUID id) {
		return (List<Broodmare>) broodRepo.findByUserId(id);
	}
}
