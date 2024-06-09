package com.gopi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopi.dto.UserCreateDto;
import com.gopi.dto.UserResponseDto;
import com.gopi.dto.UserUpdateDto;
import com.gopi.entity.User;
import com.gopi.repository.UserRepository;
import com.gopi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserResponseDto createUser(UserCreateDto createUser) {
		User user = new User();
		user.setUserName(createUser.getUsername());
		user.setFirstName(createUser.getFirstName());
		user.setLastName(createUser.getLastName());
		user.setEmail(createUser.getEmail());
		user.setPassword(createUser.getPassword());
		//setting the default values 
		user.setActive(true);
		user.setRole("USER_ROLE");
		user.setPhoneNumber(createUser.getPhoneNumber());
		
		User savedUser =userRepository.save(user);
		
		return convertUserToUserResponseDto(savedUser) ;
	}
	
	

	@Override
	public List<UserResponseDto> getAllUsers() {
		List<User> allUsers= userRepository.findAll();
		List<UserResponseDto> userResponseDtoAllUsers = new   ArrayList<UserResponseDto>();
		for(User user : allUsers ) {
			userResponseDtoAllUsers.add(convertUserToUserResponseDto(user));
		}
		return userResponseDtoAllUsers;
	}

	@Override
	public UserResponseDto getUserByID(Long id) {
		User user =userRepository.findById(id).get();
		UserResponseDto userResponseDto = convertUserToUserResponseDto(user);
		return userResponseDto;
	}
	
	@Override
	public UserResponseDto updateUser(Long id ,  UserUpdateDto userUpdateDto) {
		User user = userRepository.findById(id).get();
		
        if (userUpdateDto.getEmail() != null) 
        	user.setEmail(userUpdateDto.getEmail());
        if (userUpdateDto.getPassword() != null) 
        	user.setPassword(userUpdateDto.getPassword());
        if (userUpdateDto.getFirstName() != null)
        	user.setFirstName(userUpdateDto.getFirstName());
        if (userUpdateDto.getLastName() != null) 
        	user.setLastName(userUpdateDto.getLastName());
        if (userUpdateDto.getPhoneNumber() != null) 
        	user.setPhoneNumber(userUpdateDto.getPhoneNumber());
        User UpdatedUser = userRepository.save(user);
        
        UserResponseDto UserResponseDto=  convertUserToUserResponseDto(UpdatedUser);
		return UserResponseDto;
	}
	
	@Override
	public UserResponseDto findByUserNameAndEmail(String userName, String email) {
		User user = userRepository.findByUserNameAndEmail(userName, email);
		UserResponseDto userResponseDto =convertUserToUserResponseDto(user);
		return userResponseDto;
	}
	
	
	public UserResponseDto convertUserToUserResponseDto(User savedUser) {
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setFirstName(savedUser.getFirstName());
		userResponseDto.setLastName(savedUser.getLastName());
		userResponseDto.setUserName(savedUser.getUserName());
		userResponseDto.setEmail(savedUser.getEmail());
		userResponseDto.setId(savedUser.getId());
		userResponseDto.setActive(savedUser.isActive());
		userResponseDto.setRole(savedUser.getRole());
		userResponseDto.setPhoneNumber(savedUser.getPhoneNumber());
		
		return userResponseDto;
		
	}



	



	



	



	
}
