//package com.ryan.horsegod.services;
//
//import java.util.Optional;
//import java.util.UUID;
//
//import org.springframework.stereotype.Service;
//
//import com.ryan.horsegod.models.Trait;
//import com.ryan.horsegod.repositories.TraitRepository;
//
//@Service
//public class TraitService {
//	private TraitRepository traitRepo;
//	
//	public TraitService(TraitRepository traitRepo) {
//		this.traitRepo = traitRepo;
//	}
//	public void createTraits(Trait t) {
//		traitRepo.save(t);
//	}
//	public Trait showAll(UUID id) {
//		Optional<Trait> optionalTrait = traitRepo.findAllById(id);
//		if(optionalTrait.isPresent()) {
//			return optionalTrait.get();
//		} else {
//			return null;
//		}
//	}
//}
