package com.akp.area.Dtos;

import java.util.*;

import com.akp.area.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursorDto<T> {

	private List<User> data;
	
	private long nextCursor;
	
	private boolean hasNext;
}
