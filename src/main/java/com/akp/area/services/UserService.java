package com.akp.area.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.akp.area.Dtos.RegisterDto;
import com.akp.area.Dtos.UserDtos;
import com.akp.area.entity.User;
import com.akp.area.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	public RegisterDto register(RegisterDto registerDto) {
		User user=modelMapper.map(registerDto, User.class);
		User saveUser=userRepository.save(user);
		return modelMapper.map(saveUser, RegisterDto.class);
	}
	
	public UserDtos getAllUsers(int page,int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<User> userPage=userRepository.findAll(pageable);
		return new UserDtos(
				userPage.getContent(),
				userPage.getNumber(),
				userPage.getNumberOfElements(),
				userPage.getTotalPages(), userPage.getSize(), userPage.isLast());
	}
	
}
