package com.ryan.horsegod.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.Stud;

@Repository
public interface StudRepository extends CrudRepository<Stud, UUID> {

	List<Stud> findByUserId(UUID id);

}
