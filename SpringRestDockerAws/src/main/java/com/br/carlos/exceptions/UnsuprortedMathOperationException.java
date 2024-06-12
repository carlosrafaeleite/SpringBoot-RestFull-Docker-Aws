package com.br.carlos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsuprortedMathOperationException extends RuntimeException{

	public UnsuprortedMathOperationException(String ex) {
		super(ex);
	}

	private static final long serialVersionUID = 1L;


}
