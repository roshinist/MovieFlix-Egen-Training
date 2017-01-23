package io.roshini.spring_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 286572075790875086L;	

	public BadRequestException(String message){
		super(message);
	}
	
	public BadRequestException(String message, Throwable cause){
		super(message,cause);
	}
}
