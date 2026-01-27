package com.sasp.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sasp.entity.Member;
import com.sasp.repository.MemberRepository;
import com.sasp.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public ResponseEntity<Long> getMemberId(Long id) {
		if(id!=0 || id!=0L) {
			Optional<Member> member=memberRepository.findById(id);
			return ResponseEntity.ok(member.get().getId());
		}else {
			throw new NullPointerException("id is null");
		}
	}

}
