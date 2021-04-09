package com.scribe.jessica.hoyer.exceptions;

// thrown when a user tries to use a username that's already taken
public class UsernameTakenException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public UsernameTakenException(String message) {
		super(message);
	}

}
