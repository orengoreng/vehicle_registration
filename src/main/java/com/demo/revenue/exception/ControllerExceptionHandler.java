package com.demo.revenue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> serverError(Exception ex, WebRequest request) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ ResourceNotFoundException.class })
	public ResponseEntity<Object> resourceError(ResourceNotFoundException ex,
			WebRequest request) {
		return new ResponseEntity<>(ex.getErrMesage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
