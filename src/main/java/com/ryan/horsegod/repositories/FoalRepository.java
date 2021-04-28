package com.ryan.horsegod.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.Foal;

@Repository
public interface FoalRepository extends CrudRepository<Foal, UUID>{
	List<Foal> findByUserId(UUID id);
}
