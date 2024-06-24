package com.gopi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserName(String userName);
	
	public boolean existsByEmailId(String emailId);
	
	Optional<User> findByUserNameOrEmailId(String userName, String emailId);
	
}
