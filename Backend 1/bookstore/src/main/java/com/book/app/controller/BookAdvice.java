package com.book.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.book.app.exceptions.EmployeeException;

@RestControllerAdvice
public class BookAdvice {
	@ExceptionHandler(value = {EmployeeException.class})
	
	public ResponseEntity<String> Exception1(EmployeeException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
