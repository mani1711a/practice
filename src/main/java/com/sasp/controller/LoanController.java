package com.sasp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sasp.model.CommonResponseDto;
import com.sasp.model.LoanDto;
import com.sasp.service.LoanService;

@RestController
@RequestMapping("v1/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@PostMapping()
	public ResponseEntity<CommonResponseDto> createLoan(@RequestBody LoanDto loanDto){
		return loanService.createLoan(loanDto);
	}

}
