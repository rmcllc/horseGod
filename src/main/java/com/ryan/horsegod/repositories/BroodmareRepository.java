package com.ryan.horsegod.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.Broodmare;

@Repository
public interface BroodmareRepository extends CrudRepository<Broodmare, UUID> {

	List<Broodmare> findByUserId(UUID id);

}
