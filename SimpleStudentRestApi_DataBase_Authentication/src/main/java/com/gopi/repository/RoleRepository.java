package com.gopi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gopi.entity.Role;

public interface RoleRepository  extends JpaRepository<Role, Long>  {

	
}
