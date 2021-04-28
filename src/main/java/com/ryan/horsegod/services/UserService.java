package com.ryan.horsegod.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.User;
import com.ryan.horsegod.repositories.RoleRepository;
import com.ryan.horsegod.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepo;
	private RoleRepository roleRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepo, RoleRepository roleRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_USER"));
		userRepo.save(user);
	}
	
	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
		userRepo.save(user);
	}
	
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
//	public User createUser(User u) {
//		String hashed = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
//        u.setPassword(hashed);
//		return userRepo.save(u);
//	}
	
	public User updateUser(UUID id, String username, String fname, String lname, String state, Long zip, User user) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			User editUser = optionalUser.get();
			editUser.setUsername(username);
			editUser.setFname(fname);
			editUser.setLname(lname);
			editUser.setState(state);
			editUser.setZip(zip);
			userRepo.save(editUser);
		} else {
			return null;
		}
		return null;
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> allUsers() {
		return (List<User>) userRepo.findAll();
	}
	
	public User findUser(UUID id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	public void deleteUser(UUID id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(optionalUser.isPresent()) {
			User deleteThisUser = optionalUser.get();
			userRepo.delete(deleteThisUser);
		}
	}
}
