package com.sasp.cutomexceptions;

public class InvalidPasswordException extends RuntimeException{

	public InvalidPasswordException(String message){
		super(message);
	}
}
