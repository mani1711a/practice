package com.sasp.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sasp.entity.Loan;
import com.sasp.entity.Member;
import com.sasp.model.CommonResponseDto;
import com.sasp.model.LoanDto;
import com.sasp.repository.LoanRepository;
import com.sasp.repository.MemberRepository;

@Service
public class LoanService {
	
	private LoanRepository loanRepository;

	private MemberRepository memberRepository;
	
	LoanService(MemberRepository memberRepository){
		this.memberRepository=memberRepository;
	}
	
	public ResponseEntity<CommonResponseDto> createLoan(LoanDto loanDto) {
		Optional<Member> member=memberRepository.findById(loanDto.getLoanMemberId());
		Optional<Member> suretyMember=memberRepository.findById(loanDto.getLoanSuretyMemberId());
		
		Loan loan=new Loan();
		
		loan.setLoanAmount(loanDto.getLoanAmount());
		loan.setLoanIssuedDate(LocalDateTime.now());
		loan.setLoanPendingAmount(loanDto.getLoanAmount());
		loan.setLoanPendingMonths(loanDto.getLoanPendingMonths());
		loan.setLoanStatus("Active");
		loan.setLoanTotalMonths(loanDto.getLoanTotalMonths());
		loan.setLoanType("General");
		loan.setLoanUpdatedDate(LocalDateTime.now());
		loan.setLoanMember(member.get());
		loan.setLoanSuretyMember(suretyMember.get());
		
		System.out.println(loan);
		loanRepository.save(loan);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new CommonResponseDto(
				"Loan created Successfully", HttpStatus.CREATED,LocalDateTime.now()));
		
	}
}
