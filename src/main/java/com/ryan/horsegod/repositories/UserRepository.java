package com.ryan.horsegod.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ryan.horsegod.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

	User findByUsername(String username);
	User findByEmail(String email);
}
