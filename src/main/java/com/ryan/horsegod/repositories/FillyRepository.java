package com.ryan.horsegod.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.Filly;

@Repository
public interface FillyRepository extends CrudRepository<Filly, UUID>{

	List<Filly> findByUserId(UUID id);

}
