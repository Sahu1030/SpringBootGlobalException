package com.sarat.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandller {
	
	@ExceptionHandler
	public ResponseEntity<EmployErrorResponse> handleException(EmployNotFoundException exe)
	{
		
		EmployErrorResponse eer = new EmployErrorResponse();
		eer.setCode(HttpStatus.NOT_FOUND.value());
		eer.setMessage(exe.getMessage());
		eer.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployErrorResponse>(eer,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployErrorResponse> handleException(Exception exe)
	{
		
		EmployErrorResponse eer = new EmployErrorResponse();
		eer.setCode(HttpStatus.BAD_REQUEST.value());
		eer.setMessage(exe.getMessage());
		eer.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<EmployErrorResponse>(eer,HttpStatus.BAD_REQUEST);
		
	}
	


}
