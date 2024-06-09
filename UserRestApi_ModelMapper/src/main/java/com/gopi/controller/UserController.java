package com.gopi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gopi.dto.UserCreateDto;
import com.gopi.dto.UserResponseDto;
import com.gopi.dto.UserUpdateDto;
import com.gopi.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreateDto userCreateDto){
		UserResponseDto createdUser =userService.createUser(userCreateDto);
		return ResponseEntity.status(201).body(createdUser);
		
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserResponseDto>> getAllUsers(){
		List<UserResponseDto> allUsers =userService.getAllUsers();
		return ResponseEntity.status(200).body(allUsers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long id) {
		UserResponseDto userResponseDto = userService.getUserByID(id);
		return userResponseDto != null  ? ResponseEntity.status(200).body(userResponseDto) : ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") Long id ,@Valid @RequestBody UserUpdateDto userUpdateDto) {
		UserResponseDto userResponseDto = userService.updateUser(id, userUpdateDto);
		return userResponseDto != null  ? ResponseEntity.status(200).body(userResponseDto) : ResponseEntity.notFound().build();
		
	}
	
	//http://localhost:8080/users/search?userName=Gopi_Chandu&email=tirumala@gmail.com
	@GetMapping("/search")
	public  ResponseEntity<UserResponseDto> getuserByEmailAndUserName(@RequestParam("userName") String userName ,@RequestParam("email") String email){
		UserResponseDto userResponseDto =userService.findByUserNameAndEmail(userName, email);
		return userResponseDto != null  ? ResponseEntity.status(200).body(userResponseDto) : ResponseEntity.notFound().build();
		
	}
}
