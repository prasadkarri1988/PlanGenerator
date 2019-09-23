package com.lendico.plan.borrowergenerator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.lendico.plan.borrowergenerator.model.LoanInfo;
import com.lendico.plan.borrowergenerator.model.RepaymentPay;

public interface IBorrowerPlanController {
	List<RepaymentPay> planGenerator(@RequestBody LoanInfo loaninfo);
}
