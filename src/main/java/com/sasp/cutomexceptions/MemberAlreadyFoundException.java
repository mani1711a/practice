package com.sasp.cutomexceptions;

public class MemberAlreadyFoundException extends RuntimeException{
	
	public MemberAlreadyFoundException(String message) {
		super(message);
	}

}
