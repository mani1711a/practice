package com.sasp.service;

import org.springframework.web.multipart.MultipartFile;

import com.sasp.model.CommonResponseDto;
import com.sasp.model.LoginDto;
import com.sasp.model.LoginResponseDto;
import com.sasp.model.MemberDto;

public interface AuthService {

	
	public CommonResponseDto registerMember(MemberDto memberDto, MultipartFile uimg);

	public LoginResponseDto login(LoginDto loginDto);
}
