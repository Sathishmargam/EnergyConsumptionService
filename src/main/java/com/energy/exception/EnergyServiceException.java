package com.energy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnergyServiceException extends RuntimeException{

	public EnergyServiceException(String errorMessage) {
		super(errorMessage);
	}
}
