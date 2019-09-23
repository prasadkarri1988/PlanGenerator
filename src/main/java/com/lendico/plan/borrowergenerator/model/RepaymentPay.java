package com.lendico.plan.borrowergenerator.model;

public class RepaymentPay {
	
	double borrowerPaymentAmount;
	String date;
	double initialOutstandingPrincipal;
	double interest;
	double principal;
	double remainingOutstandingPrincipal;
	
	
	
	public RepaymentPay(double borrowerPaymentAmount, double initialOutstandingPrincipal, double interest,
			double principal, double remainingOutstandingPrincipal, String date) {
		super();
		this.borrowerPaymentAmount = borrowerPaymentAmount;
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
		this.interest = interest;
		this.principal = principal;
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
		this.date = date;
	}


	public double getBorrowerPaymentAmount() {
		return borrowerPaymentAmount;
	}


	public void setBorrowerPaymentAmount(double borrowerPaymentAmount) {
		this.borrowerPaymentAmount = borrowerPaymentAmount;
	}


	public double getInitialOutstandingPrincipal() {
		return initialOutstandingPrincipal;
	}


	public void setInitialOutstandingPrincipal(double initialOutstandingPrincipal) {
		this.initialOutstandingPrincipal = initialOutstandingPrincipal;
	}


	public double getInterest() {
		return interest;
	}


	public void setInterest(double interest) {
		this.interest = interest;
	}


	public double getPrincipal() {
		return principal;
	}


	public void setPrincipal(double principal) {
		this.principal = principal;
	}


	public double getRemainingOutstandingPrincipal() {
		return remainingOutstandingPrincipal;
	}


	public void setRemainingOutstandingPrincipal(double remainingOutstandingPrincipal) {
		this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	

}
