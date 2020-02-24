package com.energy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.energy.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class EnergyConsumptionExceptionHandler extends ResponseEntityExceptionHandler{

	private final Logger LOG = LoggerFactory.getLogger(EnergyConsumptionExceptionHandler.class);
	
	 @ExceptionHandler(Exception.class)
	  public final ResponseEntity<ErrorResponse> handleGeneralException(Exception ex, WebRequest request) {
		  ErrorResponse exceptionResponse = new ErrorResponse();
		  exceptionResponse.setErrorMessage(ex.getMessage());
		  exceptionResponse.setStatus(true);
		  LOG.info("Exception thrown with the error message :"+ex.getMessage());
	    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
