package com.ryan.horsegod.services;

import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Role;
import com.ryan.horsegod.repositories.RoleRepository;

@Service
public class RoleService {
	private RoleRepository roleRepo;
	
	public RoleService(RoleRepository roleRepo) {
		this.roleRepo = roleRepo;
	}
	
	public Role create(Role r) {
		return roleRepo.save(r);
	}
}
