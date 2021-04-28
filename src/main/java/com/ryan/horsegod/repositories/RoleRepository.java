package com.ryan.horsegod.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, UUID> {

	List<Role> findByName(String name);

}
