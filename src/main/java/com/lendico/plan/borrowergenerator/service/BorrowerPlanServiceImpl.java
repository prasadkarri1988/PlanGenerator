package com.lendico.plan.borrowergenerator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lendico.plan.borrowergenerator.model.LoanInfo;
import com.lendico.plan.borrowergenerator.model.RepaymentPay;
import com.lendico.plan.borrowergenerator.utility.UtilityforCalulation;

@Service
public class BorrowerPlanServiceImpl implements IBorrowerPlanService {

	@Autowired
	private UtilityforCalulation utilityforCalulation;

	public static final int DAYS_IN_MONTH = 30;
	public static final int DAYS_IN_YEAR = 360;

	private double emiCalculation(double loanAmount, double rate, double time) {
		double borrowerPaymentAmount = (loanAmount * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);
		return utilityforCalulation.roundOfValue(borrowerPaymentAmount);
	}

	private double interestCalculation(double initialOutstandingPrincipal, int daysInMonth, double normalRate,
			int yearsDays) {
		double interest = (initialOutstandingPrincipal * daysInMonth * normalRate) / yearsDays;
		interest = utilityforCalulation.convertToEuros(interest);
		interest = utilityforCalulation.roundOfValue(interest);
		return interest;
	}

	private double getremainingOutstandingPrincipal(double initialOutstandingPrincipal, double emiPriciple) {
		double remainingOutstandingPrincipal = initialOutstandingPrincipal - emiPriciple;
		return utilityforCalulation.roundOfValue(remainingOutstandingPrincipal);
	}

	private List<RepaymentPay> calculatePlanGenerator(LoanInfo loan) {

		double interest, emiPriciple, borrowerPaymentAmount, remainingOutstandingPrincipal;
		List<RepaymentPay> list = new ArrayList<RepaymentPay>();
		double rate = utilityforCalulation.convertInterst(loan.getNominalRate());
		double normalRate = loan.getNominalRate();
		double initialOutstandingPrincipal = loan.getLoanAmount();
		int time = loan.getDuration();
		String startDate=loan.getStartDate();
		borrowerPaymentAmount = emiCalculation(loan.getLoanAmount(), rate, loan.getDuration());
		for (int i = 1; i <= time; i++) {
			interest = interestCalculation(initialOutstandingPrincipal, DAYS_IN_MONTH, normalRate, DAYS_IN_YEAR);
			if (!(borrowerPaymentAmount > initialOutstandingPrincipal)) {
				emiPriciple = borrowerPaymentAmount - interest;
				emiPriciple = utilityforCalulation.roundOfValue(emiPriciple);
			}else {
				borrowerPaymentAmount = initialOutstandingPrincipal + interest;
				emiPriciple = initialOutstandingPrincipal;
			}
			remainingOutstandingPrincipal = getremainingOutstandingPrincipal(initialOutstandingPrincipal, emiPriciple);
			RepaymentPay repaymentPay = new RepaymentPay(borrowerPaymentAmount, initialOutstandingPrincipal, interest,emiPriciple, remainingOutstandingPrincipal, startDate);
			list.add(repaymentPay);
			
			if (remainingOutstandingPrincipal > 0) {
				initialOutstandingPrincipal = remainingOutstandingPrincipal;
			}
			startDate=utilityforCalulation.getNextMonthEmiDate(startDate);
		}
		return list;
	}

	// Plan generator service generate the repose based on loan info request
	@Override
	public List<RepaymentPay> planGenerator(LoanInfo loan) {
		List<RepaymentPay> repaymentPayList = calculatePlanGenerator(loan);
		return repaymentPayList;
	}

}
