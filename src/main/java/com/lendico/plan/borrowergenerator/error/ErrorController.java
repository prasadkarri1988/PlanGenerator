package com.lendico.plan.borrowergenerator.error;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{

	  @RequestMapping("/error")
	  @ResponseBody
	  public ResponseEntity<ErrorDetails> handleError(HttpServletRequest request) {
	      String Details=" Requested Page is not avalable please check URL";
	      ErrorDetails errorDetails = new ErrorDetails(new Date(), "404 Not Found",Details);
		    return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	  }

	  @Override
	  public String getErrorPath() {
	      return "/error";
	  }
}
