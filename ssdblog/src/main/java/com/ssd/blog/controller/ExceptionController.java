package com.ssd.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ssd.blog.exceptions.PostResponseException;

@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<?> exceptionHaldling(PostResponseException ps, WebRequest webRequest ){
		
		return new ResponseEntity<Object>(ps.getMessage(), HttpStatus.BAD_REQUEST);
		
	}
	
	
}
