package com.sasp.controller;

import java.util.Optional;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasp.entity.Member;
import com.sasp.model.CommonResponseDto;
import com.sasp.model.LoginDto;
import com.sasp.service.LoginService;

@RestController
@RequestMapping("v1/member")
public class LoginController {
	
	private LoginService loginService;
	
	LoginController(LoginService loginService){
		this.loginService=loginService;
	}

	@PostMapping("/login")
	public ResponseEntity<CommonResponseDto> login(@RequestBody LoginDto loginDto) {
		CommonResponseDto response=loginService.login(loginDto);
		return ResponseEntity.ok(response);
	}
	
}
