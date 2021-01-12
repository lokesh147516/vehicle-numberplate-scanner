package com.rule.violation.details.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VehicleNotPresentException extends RuntimeException {

	public VehicleNotPresentException(String string) {
		super(string);
	}

}
