package com.priyank.microservicebasics.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> allExceptionhandler(Exception ex, WebRequest request) {
	
		ErrorDetail detail = new ErrorDetail(ex.getMessage(), new Date(), request.getDescription(false));
		
	  return new ResponseEntity<Object>(detail, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<Object> userNotFoundExceptionhandler(Exception ex, WebRequest request) {
	
		ErrorDetail detail = new ErrorDetail(ex.getMessage(), new Date(), request.getDescription(false));
		
	  return new ResponseEntity<Object>(detail, HttpStatus.NOT_FOUND);
	}

	
}
