package com.akp.area.exceptions;


public class UserAlreadyExists extends RuntimeException{	
	public UserAlreadyExists(String message) {
		super(message);
	}
}
