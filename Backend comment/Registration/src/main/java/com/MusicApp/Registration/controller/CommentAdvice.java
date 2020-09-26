package com.MusicApp.Registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.MusicApp.Registration.Exception.CommentException;

@RestControllerAdvice
public class CommentAdvice {
	@ExceptionHandler(value = { CommentException.class })

	public ResponseEntity<String> ExceptionWhenNoComment(CommentException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
