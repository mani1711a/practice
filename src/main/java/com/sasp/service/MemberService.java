package com.sasp.service;

import org.springframework.http.ResponseEntity;

import com.sasp.entity.Member;

public interface MemberService {

	public ResponseEntity<Long> getMemberId(Long id);
}
