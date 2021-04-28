package com.ryan.horsegod.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.Colt;

@Repository
public interface ColtRepository extends CrudRepository<Colt, UUID>{

	List<Colt> findByUserId(UUID id);

}
