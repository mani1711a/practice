package com.sasp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sasp.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long>{

	Optional<Member> findById(int id);

	boolean existsByMemberId(int memberId);


}
