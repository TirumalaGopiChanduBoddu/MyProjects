package com.gopi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gopi.dto.UserCreateDto;
import com.gopi.dto.UserResponseDto;
import com.gopi.dto.UserUpdateDto;

@Service
public interface UserService {

	public UserResponseDto createUser(UserCreateDto user);
	
	public List<UserResponseDto> getAllUsers();
	
	public UserResponseDto getUserByID(Long id);
	
	public UserResponseDto updateUser(Long id,  UserUpdateDto userUpdateDto);
	
	public UserResponseDto findByUserNameAndEmail(String userName , String email);
	
}
