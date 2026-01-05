package com.sasp.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Loan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String loanType;
	
	private Double loanAmount;
	
	private Double loanPendingAmount;
	
	private LocalDateTime loanIssuedDate;
	
	private LocalDateTime loanUpdatedDate;
	
	private int loanPendingMonths;
	
	private int loanTotalMonths;
	
	private String loanStatus;
	
	@OneToOne
	@JoinColumn(name="sno_member_id", referencedColumnName ="id")
	private Member loanMember;
	
	@OneToOne
	@JoinColumn(name="sno_surety_member_id", referencedColumnName = "id")
	private Member loanSuretyMember;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Member getLoanMember() {
		return loanMember;
	}

	public void setLoanMember(Member loanMember) {
		this.loanMember = loanMember;
	}

	public Member getLoanSuretyMember() {
		return loanSuretyMember;
	}

	public void setLoanSuretyMember(Member loanSuretyMember) {
		this.loanSuretyMember = loanSuretyMember;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", loanType=" + loanType + ", loanAmount=" + loanAmount + ", loanPendingAmount="
				+ loanPendingAmount + ", loanIssuedDate=" + loanIssuedDate + ", loanUpdatedDate=" + loanUpdatedDate
				+ ", loanPendingMonths=" + loanPendingMonths + ", loanTotalMonths=" + loanTotalMonths + ", loanStatus="
				+ loanStatus + ", loanMember=" + loanMember + ", loanSuretyMember=" + loanSuretyMember + "]";
	}

	public Loan(Long id, String loanType, Double loanAmount, Double loanPendingAmount, LocalDateTime loanIssuedDate,
			LocalDateTime loanUpdatedDate, int loanPendingMonths, int loanTotalMonths, String loanStatus,
			Member loanMember, Member loanSuretyMember) {
		super();
		this.id = id;
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.loanPendingAmount = loanPendingAmount;
		this.loanIssuedDate = loanIssuedDate;
		this.loanUpdatedDate = loanUpdatedDate;
		this.loanPendingMonths = loanPendingMonths;
		this.loanTotalMonths = loanTotalMonths;
		this.loanStatus = loanStatus;
		this.loanMember = loanMember;
		this.loanSuretyMember = loanSuretyMember;
	}

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}


}
