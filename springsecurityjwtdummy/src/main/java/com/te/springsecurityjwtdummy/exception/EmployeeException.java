package com.te.springsecurityjwtdummy.exception;

public class EmployeeException extends RuntimeException {

	private String message;

	public EmployeeException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
