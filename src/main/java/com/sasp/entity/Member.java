package com.sasp.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name="member")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Member {
	
	@Id
	private Long id;
	
	private String name;
	
	private String password;
	
	private String phone;
	
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId",referencedColumnName = "id")
	private MemberAddress address;
	
	private String image;

	private LocalDateTime createdTime;
	
	private LocalDateTime updatedTime;
	
	private Character status;
	
	private Character type;
	
	private String aadharNo;
	
	

	
	
	
}
