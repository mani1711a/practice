package com.sasp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasp.entity.Member;
import com.sasp.service.MemberService;

@RestController
@RequestMapping("v1/member")
public class MemberController {

	private MemberService memberService;
	
	MemberController(MemberService memberService){
		this.memberService =memberService;
	}
	
	@GetMapping()
	public ResponseEntity<Long> getMember(@PathVariable Long memberId){
		return memberService.getMemberId(memberId);
	}
}
