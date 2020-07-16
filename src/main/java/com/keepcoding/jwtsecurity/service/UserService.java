package com.keepcoding.jwtsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.keepcoding.jwtsecurity.model.User;
import com.keepcoding.jwtsecurity.repository.UserRepository;

// Habría que crear interface pero para efectos prácticos no lo creamos

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public User findUserByName(String name) {
		return userRepository.findByName(name);
	}
	
	public User addUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
