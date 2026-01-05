package com.sasp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class CommonResponseDto {
	
	private String message;
	private HttpStatus statusCode;
	private LocalDateTime timestamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "CommonResponseDto [message=" + message + ", statusCode=" + statusCode + ", timestamp=" + timestamp
				+ "]";
	}
	public CommonResponseDto(String message, HttpStatus statusCode, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.timestamp = timestamp;
	}
	public CommonResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
