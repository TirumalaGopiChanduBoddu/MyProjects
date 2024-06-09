package com.gopi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
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
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserResponseDto createUser(UserCreateDto createUser) {
		
		User user =modelMapper.map(createUser, User.class);
		//setting the default values 
		user.setActive(true);
		user.setRole("USER_ROLE");
		User savedUser =userRepository.save(user);
		UserResponseDto userResponseDto =modelMapper.map(savedUser, UserResponseDto.class);
		return userResponseDto ;
		
	}
	
	

	@Override
	public List<UserResponseDto> getAllUsers() {
		List<User> allUsers= userRepository.findAll();
		List<UserResponseDto> userResponseDtoAllUsers = new   ArrayList<UserResponseDto>();
		for(User user : allUsers ) {
			userResponseDtoAllUsers.add(modelMapper.map(user, UserResponseDto.class));
		}
		return userResponseDtoAllUsers;
	}

	@Override
	public UserResponseDto getUserByID(Long id) {
		User user =userRepository.findById(id).get();
		UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
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
        
        UserResponseDto UserResponseDto= modelMapper.map(UpdatedUser, UserResponseDto.class);
		return UserResponseDto;
	}
	
	@Override
	public UserResponseDto findByUserNameAndEmail(String userName, String email) {
		User user = userRepository.findByUserNameAndEmail(userName, email);
		UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
		return userResponseDto;
	}
	
	

	
}
