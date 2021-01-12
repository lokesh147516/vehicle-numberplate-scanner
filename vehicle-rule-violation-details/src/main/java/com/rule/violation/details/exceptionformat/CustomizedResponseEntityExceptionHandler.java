package com.rule.violation.details.exceptionformat;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rule.violation.details.exception.VehicleNotPresentException;
import com.rule.violation.details.exception.ViolationException;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ VehicleNotPresentException.class, ViolationException.class })
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionFormat format = new ExceptionFormat(ex.getMessage(), new Date(), request.getDescription(false));
		return new ResponseEntity<Object>(format, HttpStatus.NOT_FOUND);
	}

}
