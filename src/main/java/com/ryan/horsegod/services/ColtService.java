package com.ryan.horsegod.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Colt;
import com.ryan.horsegod.repositories.ColtRepository;

@Service
public class ColtService {
	private ColtRepository coltRepo;
	
	public ColtService(ColtRepository coltRepo) {
		this.coltRepo = coltRepo;
	}
	
	public void createColt(Colt c) {
		coltRepo.save(c);
	}
	
	public Colt updateColt(UUID id, Double height, Double weight, Double speed, Double gait, Double endurance) {
		Optional<Colt> optionalColt = coltRepo.findById(id);
		if(optionalColt.isPresent()) {
			Colt editColt = optionalColt.get();
			editColt.setHeight(height);
			editColt.setWeight(weight);
			editColt.setSpeed(speed);
			editColt.setGait(gait);
			editColt.setEndurance(endurance);
			coltRepo.save(editColt);
		} else {
			return null;
		}
		return null;
	}
	
	public List<Colt> allColts() {
		return (List<Colt>) coltRepo.findAll();
	}
	
	public Colt findColt(UUID id) {
		Optional<Colt> optionalColt = coltRepo.findById(id);
		if(optionalColt.isPresent()) {
			return optionalColt.get();
		} else {
			return null;
		}
	}
	
	public List<Colt> allOwnedColts(UUID id) {
		return (List<Colt>) coltRepo.findByUserId(id);
	}
}
