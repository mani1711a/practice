package com.sasp.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponseDto {

	private Long memberId;
	
	private String memberName;
	
	private String uimg;
	
	private Character role;
	
	private String status;
	
	private HttpStatus statusCode;
	
	private LocalDateTime time;
	
}
