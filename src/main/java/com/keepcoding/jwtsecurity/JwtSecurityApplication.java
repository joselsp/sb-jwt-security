package com.keepcoding.jwtsecurity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.keepcoding.jwtsecurity.model.User;
import com.keepcoding.jwtsecurity.repository.UserRepository;

@SpringBootApplication
public class JwtSecurityApplication {
	
	@Autowired
	private UserRepository userRepository;
	
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "dns", "password", "dns@gmail.com"),
				new User(102, "jorge", "password", "jorge@gmail.com"),
				new User(103, "pedro", "password", "pedro@gmail.com"),
				new User(104, "antonio", "password", "antonio@gmail.com")
		).collect(Collectors.toList());
		
		userRepository.saveAll(users);
	}

	public static void main(String[] args) { SpringApplication.run(JwtSecurityApplication.class, args);	}

}
