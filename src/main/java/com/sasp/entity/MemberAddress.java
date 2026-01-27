package com.sasp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name="memberaddress")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String pincode;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String hno;

	
}
