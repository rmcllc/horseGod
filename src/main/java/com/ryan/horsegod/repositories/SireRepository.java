package com.ryan.horsegod.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.Sire;

@Repository
public interface SireRepository extends CrudRepository<Sire, UUID> {

}
