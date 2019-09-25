package com.lendico.plan.borrowergenerator.error;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class BorrowerPlanExceptionController {
	
	 @ExceptionHandler(BorrowerPlanProcessException.class)
	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(BorrowerPlanProcessException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }

}
