package com.sasp.globalExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sasp.cutomexceptions.InvalidPasswordException;
import com.sasp.cutomexceptions.MemberAlreadyFoundException;
import com.sasp.cutomexceptions.MemberNotFoundException;
import com.sasp.cutomexceptions.UnauthorizedException;
import com.sasp.model.CommonResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(MemberNotFoundException.class)
	public ResponseEntity<CommonResponseDto> MemberNotFoundHandler(MemberNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new CommonResponseDto(ex.getMessage(),HttpStatus.NOT_FOUND,LocalDateTime.now()));
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<CommonResponseDto> InvalidPasswordHandler(InvalidPasswordException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				new CommonResponseDto(ex.getMessage(),HttpStatus.BAD_REQUEST,LocalDateTime.now()));
	}
	
	@ExceptionHandler(MemberAlreadyFoundException.class)
	public ResponseEntity<CommonResponseDto> memberFoundHandler(MemberAlreadyFoundException ex){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new CommonResponseDto(ex.getMessage(),HttpStatus.CONFLICT,LocalDateTime.now()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CommonResponseDto> exceptionHandler(Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
				new CommonResponseDto(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,LocalDateTime.now()));
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<CommonResponseDto> RunTimeExceptionHandler(RuntimeException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new CommonResponseDto(e.getMessage(),HttpStatus.CONFLICT,LocalDateTime.now()));
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<CommonResponseDto> UnAuthorizedExceptionHandler(RuntimeException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new CommonResponseDto(e.getMessage(),HttpStatus.CONFLICT,LocalDateTime.now()));
				
	}
}
