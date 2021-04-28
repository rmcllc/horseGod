package com.ryan.horsegod.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ryan.horsegod.models.Role;
import com.ryan.horsegod.models.User;
import com.ryan.horsegod.repositories.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	private UserRepository userRepo;
	
	public UserDetailService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	}
	private List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role : user.getRoles()) {
			GrantedAuthority grantedAuth = new SimpleGrantedAuthority(role.getName());
			authorities.add(grantedAuth);
		}
		return authorities;
	}
	
	@Transactional
	public boolean isUsernameAlreadyInUse(String username) {
		boolean userInDb = true;
		if(userRepo.findByUsername(username) == null) {
			userInDb = false;
		}
		return userInDb;
	}
	
	@Transactional
	public boolean isEmailAlreadyInUse(String email) {
		boolean emailInDb = true;
		if(userRepo.findByEmail(email) == null) {
			emailInDb = false;
		}
		return emailInDb;
	}
}
