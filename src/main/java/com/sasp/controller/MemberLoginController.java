package com.sasp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasp.model.CommonResponseDto;
import com.sasp.model.LoginDto;
import com.sasp.model.LoginResponseDto;
import com.sasp.service.AuthService;

@RestController
@RequestMapping("v1/auth/member")
public class MemberLoginController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
		LoginResponseDto response=authService.login(loginDto);
		return ResponseEntity.ok(response);
	}
}
