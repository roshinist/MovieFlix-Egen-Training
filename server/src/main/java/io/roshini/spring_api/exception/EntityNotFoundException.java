package io.roshini.spring_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 286572075790875086L;	

	public EntityNotFoundException(String message){
		super(message);
	}
	
	public EntityNotFoundException(String message, Throwable cause){
		super(message,cause);
	}
}
