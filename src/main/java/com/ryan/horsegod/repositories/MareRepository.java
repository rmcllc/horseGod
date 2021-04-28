package com.ryan.horsegod.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.Mare;

@Repository
public interface MareRepository extends CrudRepository<Mare, UUID> {

	List<Mare> findByUserId(UUID id);



}
