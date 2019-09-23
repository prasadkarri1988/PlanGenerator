package com.lendico.plan.borrowergenerator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lendico.plan.borrowergenerator.error.BorrowerPlanProcessException;
import com.lendico.plan.borrowergenerator.model.LoanInfo;
import com.lendico.plan.borrowergenerator.model.RepaymentPay;
import com.lendico.plan.borrowergenerator.service.IBorrowerPlanService;

@RestController
public class BorrowerPlanControllerImpl implements IBorrowerPlanController {

	@Autowired
	IBorrowerPlanService generatePlanService;

	@Override
	@RequestMapping(value = "/generate-plan", method = RequestMethod.POST, consumes = {"application/json" }, produces = { "application/json" })
	public List<RepaymentPay> planGenerator(@Valid @RequestBody LoanInfo loaninfo) {

		try{
		List<RepaymentPay>  repaymentPay = generatePlanService.planGenerator(loaninfo);
		return repaymentPay;
		}
		catch(Exception e){
			throw new BorrowerPlanProcessException("generatePlanService processing error");
		}
	}

}
