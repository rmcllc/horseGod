package com.ryan.horsegod.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Dam;
import com.ryan.horsegod.repositories.DamRepository;

@Service
public class DamService {
	private DamRepository damRepo;
	
	public DamService(DamRepository damRepo) {
		this.damRepo = damRepo;
	}
	
	public void createDam(Dam d) {
		damRepo.save(d);
	}
	
//	public Dam updateDam(UUID id, Double height, Double weight, Double speed, Double gait, Double endurance) {
//		Optional<Dam> optionalDam = damRepo.findById(id);
//		if(optionalDam.isPresent()) {
//			Dam editDam = optionalDam.get();
//			editDam.setHeight(height);
//			editDam.setWeight(weight);
//			editDam.setSpeed(speed);
//			editDam.setGait(gait);
//			editDam.setEndurance(endurance);
//			damRepo.save(editDam);
//		} else {
//			return null;
//		}
//		return null;
//	}
//	
	public List<Dam> allDams() {
		return (List<Dam>) damRepo.findAll();
	}
	
	public Dam findById(UUID id) {
		Optional<Dam> optionalDam = damRepo.findById(id);
		if(optionalDam.isPresent()) {
			return optionalDam.get();
		} else {
			return null;
		}
	}
}
