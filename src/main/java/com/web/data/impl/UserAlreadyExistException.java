package com.web.data.impl;

public class UserAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public UserAlreadyExistException() {
	super();
}
public UserAlreadyExistException(String message) {
	super(message);
}
}
