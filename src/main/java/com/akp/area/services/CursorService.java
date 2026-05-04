package com.akp.area.services;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.akp.area.Dtos.CursorDto;
import com.akp.area.entity.User;
import com.akp.area.repository.UserRepository;

@Service
public class CursorService {
	
	@Autowired
	private UserRepository userRepo;

	public CursorDto<User> getAllUser(Long cursor,int limit){

		List<User> users;
		
		if(cursor == null) {
			users=userRepo.findAllByOrderByIdAsc(PageRequest.of(0, limit));
		}
		else {
			users =userRepo.findAllByIdGreaterThanOrderByIdAsc(cursor , PageRequest.of(0, limit));
		}
		
		Long nextCursor=null;
		boolean hasNext=false;
		
		if(!users.isEmpty()) {
			nextCursor=users.get(users.size()-1).getId();
			hasNext=users.size() == limit;
		}
		return new CursorDto<>(users,nextCursor,hasNext);
	}
}
