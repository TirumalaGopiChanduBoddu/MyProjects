package com.gopi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopi.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
