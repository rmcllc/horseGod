package com.ryan.horsegod.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.Dam;

@Repository
public interface DamRepository extends CrudRepository<Dam, UUID> {

}
