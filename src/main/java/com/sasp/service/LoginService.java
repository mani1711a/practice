package com.sasp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sasp.cutomexceptions.InvalidPasswordException;
import com.sasp.cutomexceptions.MemberNotFoundException;
import com.sasp.entity.Member;
import com.sasp.model.CommonResponseDto;
import com.sasp.model.LoginDto;
import com.sasp.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private MemberService memberService;

	public CommonResponseDto login(LoginDto loginDto) {
		Member member=memberService.findMember(loginDto.getId());
		System.out.println(member.getMemberId()+"//////////////"+member.getMemberPassword());
		if(!member.getMemberPassword().equals(loginDto.getPassword())) {
			throw new InvalidPasswordException( "Entered password is incorrect for Id: " + loginDto.getId());
		}
		return new CommonResponseDto("Logged In Successful",HttpStatus.OK,LocalDateTime.now());
		
	}

	
}
