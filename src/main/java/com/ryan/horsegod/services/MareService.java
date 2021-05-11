package com.ryan.horsegod.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Mare;
import com.ryan.horsegod.repositories.MareRepository;

@Service
public class MareService {
	private MareRepository mareRepo;
	
	public MareService(MareRepository mareRepo) {
		this.mareRepo = mareRepo;
	}
	
	public void createMare(Mare m) {
		mareRepo.save(m);
	}
	
	public Mare updateMare(UUID id, Double height, Double weight, Double speed, Double gait, Double endurance, UUID broodId) {
		Optional<Mare> optionalMare = mareRepo.findById(id);
		if(optionalMare.isPresent()) {
			Mare editMare = optionalMare.get();
			editMare.setHeight(height);
			editMare.setHeight(weight);
			editMare.setHeight(speed);
			editMare.setHeight(gait);
			editMare.setHeight(endurance);
			editMare.setBroodmareId(broodId);
			mareRepo.save(editMare);
		} else {
			return null;
		}
		return null;
	}
	
	public List<Mare> allMares() {
		return (List<Mare>) mareRepo.findAll();
	}
	
	public Mare findMare(UUID id) {
		Optional<Mare> optionalMare = mareRepo.findById(id);
		if(optionalMare.isPresent()) {
			return optionalMare.get();
		} else {
			return null;
		}
	}
	
	public List<Mare> allOwnedMares(UUID id) {
		return (List<Mare>) mareRepo.findByUserId(id);
	}
}
