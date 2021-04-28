package com.ryan.horsegod.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Filly;
import com.ryan.horsegod.repositories.FillyRepository;

@Service
public class FillyService {
	private FillyRepository fillyRepo;
	
	public FillyService(FillyRepository fillyRepo) {
		this.fillyRepo = fillyRepo;
	}
	
	public void createFilly(Filly f) {
		fillyRepo.save(f);
	}
	
	public Filly updateFilly(UUID id, Double height, Double weight, Double speed, Double gait, Double endurance) {
		Optional<Filly> optionalFilly = fillyRepo.findById(id);
		if(optionalFilly.isPresent()) {
			Filly editFilly = optionalFilly.get();
			editFilly.setHeight(height);
			editFilly.setWeight(weight);
			editFilly.setSpeed(speed);
			editFilly.setGait(gait);
			editFilly.setEndurance(endurance);
			fillyRepo.save(editFilly);
		} else {
			return null;
		}
		return null;
	}
			
	public List<Filly> allFillys() {
		return (List<Filly>) fillyRepo.findAll(); 
	}
	
	public Filly findFilly(UUID id) {
		Optional<Filly> optionalFilly = fillyRepo.findById(id);
		if(optionalFilly.isPresent()) {
			return optionalFilly.get();
		} else {
			return null;
		}
	}
	
	public List<Filly> allOwnedFillys(UUID id) {
		return (List<Filly>) fillyRepo.findByUserId(id);
	}
}
