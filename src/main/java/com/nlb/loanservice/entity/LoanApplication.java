package com.nlb.loanservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nlb.loanservice.constants.Rating;
import com.nlb.loanservice.constants.Status;

@Entity
@Table(name="loan")
public class LoanApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;
	private String bankName;
	private Double requestedAmount = 0.0 ;
	private Double termLength = 0.0 ;

	
	private Double minLoanAmount = 10000.0;
	private Double maxLoanAmount = 2000000.0;
	private Double minInterestRate = 0.07;
	private Double minCreditScore = 100.0;
	private Double processingFee = requestedAmount * 0.005;
	private Rating rating = Rating.SATISFIED; 
	private Status status = Status.PENDING;
	
	
	// Constructor----------------------------------------------
	public LoanApplication() {	super();	}
	
	
	public LoanApplication(int id, String bankName, double requestedAmount, double termLength) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.requestedAmount = requestedAmount;
		this.termLength = termLength;
	}
	
	public LoanApplication(int id, String bankName, double requestedAmount, double termLength, double minLoanAmount,
			double maxLoanAmount, double minInterestRate, double minCreditScore, double processingFee, Rating rating,
			Status status) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.requestedAmount = requestedAmount;
		this.termLength = termLength;
		this.minLoanAmount = minLoanAmount;
		this.maxLoanAmount = maxLoanAmount;
		this.minInterestRate = minInterestRate;
		this.minCreditScore = minCreditScore;
		this.processingFee = processingFee;
		this.rating = rating;
		this.status = status;
	}

	// Getter And Setter---------------------------------------
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBankName() {
		return bankName;
	}


	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public double getRequestedAmount() {
		return requestedAmount;
	}


	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}


	public double getTermLength() {
		return termLength;
	}


	public void setTermLength(double termLength) {
		this.termLength = termLength;
	}


	public double getMinLoanAmount() {
		return minLoanAmount;
	}


	public void setMinLoanAmount(double minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}


	public double getMaxLoanAmount() {
		return maxLoanAmount;
	}


	public void setMaxLoanAmount(double maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}


	public double getMinInterestRate() {
		return minInterestRate;
	}


	public void setMinInterestRate(double minInterestRate) {
		this.minInterestRate = minInterestRate;
	}


	public double getMinCreditScore() {
		return minCreditScore;
	}


	public void setMinCreditScore(double minCreditScore) {
		this.minCreditScore = minCreditScore;
	}


	public double getProcessingFee() {
		return processingFee;
	}


	public void setProcessingFee(double processingFee) {
		this.processingFee = processingFee;
	}


	public Rating getRating() {
		return rating;
	}


	public void setRating(Rating rating) {
		this.rating = rating;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}	
	
	
	
}
