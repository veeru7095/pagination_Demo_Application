package com.akp.area.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akp.area.Dtos.RegisterDto;
import com.akp.area.Dtos.UserDtos;
import com.akp.area.entity.User;
import com.akp.area.exceptions.UserAlreadyExists;
import com.akp.area.repository.UserRepository;
import com.akp.area.services.UserService;

@RestController
@RequestMapping("api/auth")
public class UserController {

	@Autowired
	public UserService userService;
	
	@Autowired
	public UserRepository userRepository;
	
	@PostMapping("/register")
	public ResponseEntity<RegisterDto> register(@RequestBody RegisterDto registerDto) {
		if(userRepository.existsByEmail(registerDto.getEmail())) {
			throw new UserAlreadyExists(String.format("User already exists with email %s", registerDto.getEmail()));
		}
		return new ResponseEntity<RegisterDto>(userService.register(registerDto),HttpStatus.CREATED);
	}
	
	@GetMapping
	public UserDtos getAllUsers(
			@RequestParam (defaultValue = "0") int page,
			@RequestParam (defaultValue = "5")int size
			) {
		return userService.getAllUsers(page, size);
	}
}
