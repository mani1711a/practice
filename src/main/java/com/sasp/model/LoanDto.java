package com.sasp.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sasp.entity.Member;

public class LoanDto {

	private String loanType;
	
	private Double loanAmount;
	
	private Double loanPendingAmount;
	
	private LocalDateTime loanIssuedDate;
	
	private LocalDateTime loanUpdatedDate;
	
	private int loanPendingMonths;
	
	private int loanTotalMonths;
	
	private String loanStatus;
	
	private int loanMemberId;
	
	private int loanSuretyMemberId;

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getLoanPendingAmount() {
		return loanPendingAmount;
	}

	public void setLoanPendingAmount(Double loanPendingAmount) {
		this.loanPendingAmount = loanPendingAmount;
	}

	public LocalDateTime getLoanIssuedDate() {
		return loanIssuedDate;
	}

	public void setLoanIssuedDate(LocalDateTime loanIssuedDate) {
		this.loanIssuedDate = loanIssuedDate;
	}

	public LocalDateTime getLoanUpdatedDate() {
		return loanUpdatedDate;
	}

	public void setLoanUpdatedDate(LocalDateTime loanUpdatedDate) {
		this.loanUpdatedDate = loanUpdatedDate;
	}

	public int getLoanPendingMonths() {
		return loanPendingMonths;
	}

	public void setLoanPendingMonths(int loanPendingMonths) {
		this.loanPendingMonths = loanPendingMonths;
	}

	public int getLoanTotalMonths() {
		return loanTotalMonths;
	}

	public void setLoanTotalMonths(int loanTotalMonths) {
		this.loanTotalMonths = loanTotalMonths;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public int getLoanMemberId() {
		return loanMemberId;
	}

	public void setLoanMemberId(int loanMemberId) {
		this.loanMemberId = loanMemberId;
	}

	public int getLoanSuretyMemberId() {
		return loanSuretyMemberId;
	}

	public void setLoanSuretyMemberId(int loanSuretyMemberId) {
		this.loanSuretyMemberId = loanSuretyMemberId;
	}

	@Override
	public String toString() {
		return "LoanDto [loanType=" + loanType + ", loanAmount=" + loanAmount + ", loanPendingAmount="
				+ loanPendingAmount + ", loanIssuedDate=" + loanIssuedDate + ", loanUpdatedDate=" + loanUpdatedDate
				+ ", loanPendingMonths=" + loanPendingMonths + ", loanTotalMonths=" + loanTotalMonths + ", loanStatus="
				+ loanStatus + ", loanMemberId=" + loanMemberId + ", loanSuretyMemberId=" + loanSuretyMemberId + "]";
	}

	public LoanDto(String loanType, Double loanAmount, Double loanPendingAmount, LocalDateTime loanIssuedDate,
			LocalDateTime loanUpdatedDate, int loanPendingMonths, int loanTotalMonths, String loanStatus,
			int loanMemberId, int loanSuretyMemberId) {
		super();
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.loanPendingAmount = loanPendingAmount;
		this.loanIssuedDate = loanIssuedDate;
		this.loanUpdatedDate = loanUpdatedDate;
		this.loanPendingMonths = loanPendingMonths;
		this.loanTotalMonths = loanTotalMonths;
		this.loanStatus = loanStatus;
		this.loanMemberId = loanMemberId;
		this.loanSuretyMemberId = loanSuretyMemberId;
	}

	public LoanDto() {
		super();
		// TODO Auto-generated constructor stub
	}
 
}
