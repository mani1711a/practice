package com.sasp.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sasp.cutomexceptions.MemberAlreadyFoundException;
import com.sasp.cutomexceptions.MemberNotFoundException;
import com.sasp.entity.Member;
import com.sasp.model.CommonResponseDto;
import com.sasp.repository.MemberRepository;

@Service
public class MemberService {
	
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ImageService imageService;
	
	
	public Member findMember(int id) {
		Optional<Member> member= Optional.of(memberRepository.findById(id)
		.orElseThrow(()->new MemberNotFoundException("Member Not found with Id: "+id)));
		return member.get();
	}

	public CommonResponseDto registerMember(int id, String name, String password, String phone, String email,
			String address, MultipartFile uimg) {
		
		String imageUrl="";
		if(uimg!=null && !uimg.isEmpty()) {
			imageUrl=imageService.processImageUrl(uimg);
		}
		
		Member member=new Member();
		
		member.setMemberId(id);
		member.setMemberAddress(address);
		member.setMemberEmail(email);
		member.setMemberImage(imageUrl);
		member.setMemberName(name);
		member.setMemberPassword(password);
		member.setMemberPhone(phone);
		boolean isExists=memberRepository.existsByMemberId(member.getMemberId());
		if(isExists) {
			throw new MemberAlreadyFoundException("Member already found with id: " + member.getMemberId());
		}
		memberRepository.save(member);
		return new CommonResponseDto("Member persisted successfully", HttpStatus.CREATED, LocalDateTime.now());
	}
	
	

}
