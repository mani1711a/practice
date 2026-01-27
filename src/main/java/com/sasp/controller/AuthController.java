package com.sasp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sasp.model.CommonResponseDto;
import com.sasp.model.LoginDto;
import com.sasp.model.MemberDto;
import com.sasp.service.AuthService;

@RestController
@RequestMapping("/v1/auth/admin")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	
	@PostMapping(path="/register",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<CommonResponseDto> registerMember(
	        @ModelAttribute("member") MemberDto memberDto,
	        @RequestPart("uimg") MultipartFile uimg) {
	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(authService.registerMember(memberDto, uimg));
	}

}
