package com.gopi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gopi.dto.UserResponseDto;
import com.gopi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserNameAndEmail(String userName , String email);
}
