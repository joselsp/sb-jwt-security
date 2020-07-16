package com.keepcoding.jwtsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keepcoding.jwtsecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);
}
