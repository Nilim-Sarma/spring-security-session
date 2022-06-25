package com.te.springsecurityjwtdummy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.springsecurityjwtdummy.exception.EmployeeException;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(EmployeeException.class)
	public EmployeeException getException(HttpServletRequest request , EmployeeException exception) {
		return new EmployeeException(exception.getMessage());
	}
}
