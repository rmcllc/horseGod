package com.ryan.horsegod.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Sire;
import com.ryan.horsegod.repositories.SireRepository;
import com.ryan.horsegod.repositories.StudRepository;

@Service
public class SireService {
	private final SireRepository sireRepo;
	
	public SireService(SireRepository sireRepo, StudRepository studRepo) {
		this.sireRepo = sireRepo;
	}
	
	public void createSire(Sire s) {
		sireRepo.save(s);
	}
	
	public List<Sire> allSires() {
		return (List<Sire>) sireRepo.findAll();
	}
	
	public Sire findById(UUID id) {
		Optional<Sire> optionalSire = sireRepo.findById(id);
		if(optionalSire.isPresent()) {
			return optionalSire.get();
		} else {
			return null;
		}
	}
}
