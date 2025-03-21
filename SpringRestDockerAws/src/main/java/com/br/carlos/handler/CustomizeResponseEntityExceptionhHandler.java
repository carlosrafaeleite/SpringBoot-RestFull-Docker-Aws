package com.br.carlos.handler;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.br.carlos.exceptions.ExceptionResponse;
import com.br.carlos.exceptions.InvalidJwtAuthenticationException;
import com.br.carlos.exceptions.ResourseNotFoundException;

@ControllerAdvice
@RestController
public class CustomizeResponseEntityExceptionhHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public  final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(0), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse	, HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler(ResourseNotFoundException.class)
	public  final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(0), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse	, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public  final ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationException(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(0), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(exceptionResponse	, HttpStatus.FORBIDDEN);		
	}

}
