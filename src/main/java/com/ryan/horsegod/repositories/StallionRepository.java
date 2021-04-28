package com.ryan.horsegod.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.Stallion;

@Repository
public interface StallionRepository extends CrudRepository<Stallion, UUID> {

	List<Stallion> findByUserId(UUID id);

}
