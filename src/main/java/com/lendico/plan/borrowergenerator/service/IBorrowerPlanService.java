package com.lendico.plan.borrowergenerator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lendico.plan.borrowergenerator.model.LoanInfo;
import com.lendico.plan.borrowergenerator.model.RepaymentPay;

@Service
public interface IBorrowerPlanService {

	List<RepaymentPay> planGenerator(LoanInfo loan);
	
}
