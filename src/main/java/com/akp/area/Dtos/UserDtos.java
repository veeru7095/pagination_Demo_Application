package com.akp.area.Dtos;
import java.util.*;

import com.akp.area.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtos {

	private List<User> content;
	private int pageNumber;
	private int pageSize;
	private long elements;
	private int totalPages;
	private boolean last;
	
}
