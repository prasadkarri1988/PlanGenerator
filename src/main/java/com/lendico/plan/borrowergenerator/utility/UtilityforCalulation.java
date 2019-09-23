package com.lendico.plan.borrowergenerator.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UtilityforCalulation {

	public double emiCalculation(double loanAmount, double rate, double time) {
		double e = (loanAmount * rate * Math.pow(1 + rate, time)) / (Math.pow(1 + rate, time) - 1);
		return e;
	}

	public double convertInterst(double normalRate) {

		double rate = normalRate / (12 * 100);
		return rate;

	}

	public double roundOfValue(double value) {
		double roundOff = Math.round(value * 100.0) / 100.0;
		return roundOff;

	}

	public double convertToEuros(double value) {
		double euros = value / 100;
		return euros;

	}


	public String getNextMonthEmiDate(String pattern)  {
		String dateString = pattern.substring(0, 10);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		date = cal.getTime();
		SimpleDateFormat finalFormat = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00'Z'");
		String strDate = finalFormat.format(date);
		return strDate;
	}

}
