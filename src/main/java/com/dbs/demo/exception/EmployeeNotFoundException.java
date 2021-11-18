package com.dbs.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2953783086385743796L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
