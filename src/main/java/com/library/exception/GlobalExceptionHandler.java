package com.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//This Class Will Act AS a central point
public class GlobalExceptionHandler  {
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponce handleResourceNotFound(ResourceNotFoundException ex) {
	
		ErrorResponce errorResponce = new ErrorResponce();
		errorResponce.setErrorcode(ex.getCode());
		errorResponce.setErrormessage(ex.getMessage());
		
		return errorResponce;
		
	}
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponce handleFound(Throwable ex) {
	
		ErrorResponce errorResponce = new ErrorResponce();
		errorResponce.setErrorcode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorResponce.setErrormessage("Something Went Wrong");
		
		return errorResponce;
		
	}
	 
}
