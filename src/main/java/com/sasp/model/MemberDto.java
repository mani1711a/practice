package com.sasp.model;

import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.MultipartFile;

import com.sasp.entity.MemberAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {

	private Long id;
	
	private String name;
	
	private String password;
	
	private String phone;
	
	private String email;
	
	private String aadharno;
	
	private String pincode;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String hno;
	
	private Character memberRole;

}
