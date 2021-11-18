package com.dbs.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException() {
		LOG.error("handleEmployeeNotFoundException");
		return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(SomeOtherException.class)
//	public ResponseEntity<Object> handleSomeOtherException() {
	// code
//	}

}
