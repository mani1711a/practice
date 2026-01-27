package com.sasp.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sasp.cutomexceptions.MemberNotFoundException;
import com.sasp.entity.Member;
import com.sasp.repository.MemberRepository;

@Component
public class MemberUtility {
	
	private MemberRepository memberRepository;
	
	MemberUtility(MemberRepository memberRepository){
		this.memberRepository=memberRepository;
	}

	public Member findMember(Long id) {
		Optional<Member> member= Optional.of(memberRepository.findById(id)
		.orElseThrow(()->new MemberNotFoundException("Member Not found with Id: "+id)));
		return member.get();
	}
}
