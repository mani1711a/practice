package com.sasp.serviceImpl;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sasp.cutomexceptions.InvalidPasswordException;
import com.sasp.cutomexceptions.MemberAlreadyFoundException;
import com.sasp.cutomexceptions.UnauthorizedException;
import com.sasp.entity.Member;
import com.sasp.entity.MemberAddress;
import com.sasp.model.CommonResponseDto;
import com.sasp.model.LoginDto;
import com.sasp.model.LoginResponseDto;
import com.sasp.model.MemberDto;
import com.sasp.repository.MemberRepository;
import com.sasp.service.AuthService;
import com.sasp.util.MemberUtility;

@Service
public class AuthServiceImpl implements AuthService {
	
	private MemberRepository memberRepository;
	
	private ImageService imageService;
	
	private MemberUtility memberUtility;
	
	AuthServiceImpl(MemberRepository memberRepository,
					ImageService imageService,
					MemberUtility memberUtility){
		this.memberRepository=memberRepository;
		this.imageService=imageService;
		this.memberUtility=memberUtility;
	}
	
	private static Logger LOGGER=LoggerFactory.getLogger(AuthServiceImpl.class);
	

	public CommonResponseDto registerMember(MemberDto memberDto,MultipartFile uimg) {
		LOGGER.info("Member registration using email={}",memberDto.getEmail());
		if(!memberDto.getMemberRole().equals('A')) {
			throw new UnauthorizedException("Unauthorized Admin access");
		}
		String imageUrl="";
		if(uimg!=null && !uimg.isEmpty()) {
			imageUrl=imageService.processImageUrl(uimg);
		}
		LOGGER.debug("User Image Fetched Successfully");
		
		Member member=new Member();
		member.setId(memberDto.getId());
		member.setAadharNo(memberDto.getAadharno());
		member.setCreatedTime(LocalDateTime.now());
		member.setEmail(memberDto.getEmail());
		member.setImage(imageUrl);
		member.setName(memberDto.getName());
		member.setPassword(memberDto.getPassword());
		member.setPhone(memberDto.getPhone());
		member.setStatus('A');
		member.setType('G');
		member.setUpdatedTime(LocalDateTime.now());
		
		MemberAddress memberAddress=new MemberAddress(
					);
		memberAddress.setCity(memberDto.getCity());
		memberAddress.setState(memberDto.getState());
		memberAddress.setCountry(memberDto.getCountry());
		memberAddress.setHno(memberDto.getHno());
		memberAddress.setPincode(memberDto.getPincode());
		
		
		member.setAddress(memberAddress);
		
		boolean isExists=memberRepository.existsById(memberDto.getId());
		LOGGER.warn("Member already exists id={}",member.getId());
		if(isExists) {
			throw new MemberAlreadyFoundException("Member already found with id: " + member.getId());
		}
		memberRepository.save(member);
		LOGGER.debug("Member persisted successfully using email={}",member.getEmail());
		return new CommonResponseDto("Member persisted successfully", HttpStatus.CREATED, LocalDateTime.now());
	}

	public LoginResponseDto login(LoginDto loginDto) {
		Member member=memberUtility.findMember(loginDto.getId());
		if(!member.getPassword().equals(loginDto.getPassword())) {
			throw new InvalidPasswordException( "Entered password is incorrect for Id: " + loginDto.getId());
		}
		return new LoginResponseDto(member.getId(),
				member.getName(),
				member.getImage(),
				member.getType(),
				"success",
				HttpStatus.OK,
				LocalDateTime.now());
		
	}

}
