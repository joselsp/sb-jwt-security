package com.keepcoding.jwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.jwtsecurity.model.User;
import com.keepcoding.jwtsecurity.service.UserService;
import com.keepcoding.jwtsecurity.util.JwtUtil;

@RestController
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/")
	public String securedEndPoint() {
		return "OK";
	}
	
	@PostMapping("/sign-up")
	public User signUp(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
		} catch (Exception ex) {
			return "Invalid username/password";
		}
		return jwtUtil.generateToken(user.getName());
	}
}
