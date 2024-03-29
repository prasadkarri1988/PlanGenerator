package com.lendico.plan.borrowergenerator.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LoanInfo {

	@NotNull
	double loanAmount;
	
	@NotNull
	double nominalRate;
	
	@NotNull
	@Min(5)
	int duration;
	
	@NotNull
	String startDate;

	public LoanInfo() {
		super();
	}

	public LoanInfo(double loanAmount, double nominalRate, int duration, String startDate) {
		super();
		this.loanAmount = loanAmount;
		this.nominalRate = nominalRate;
		this.duration = duration;
		this.startDate = startDate;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getNominalRate() {
		return nominalRate;
	}

	public void setNominalRate(double nominalRate) {
		this.nominalRate = nominalRate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}
