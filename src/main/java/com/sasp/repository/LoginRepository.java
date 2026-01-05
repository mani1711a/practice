package com.sasp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sasp.entity.Member;

@Repository
public interface LoginRepository extends JpaRepository<Member, Long>{
}
