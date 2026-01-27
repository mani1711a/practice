package com.sasp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sasp.entity.MemberAddress;

@Repository
public interface MemberAddressRepository extends JpaRepository<MemberAddress, Long>{

}
