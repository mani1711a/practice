package com.sasp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sasp.entity.Member;
import com.sasp.model.CommonResponseDto;
import com.sasp.service.ImageService;
import com.sasp.service.MemberService;

@RestController
@RequestMapping("/v1/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<CommonResponseDto> registerMember(@RequestParam int id,
															@RequestParam String name,
															@RequestParam String password,
															@RequestParam String phone,
															@RequestParam String email
															,@RequestParam String address
															,@RequestParam MultipartFile uimg){
		
		CommonResponseDto response=memberService.registerMember(id, name, password, phone, email, address, uimg);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				response);
	}

}
