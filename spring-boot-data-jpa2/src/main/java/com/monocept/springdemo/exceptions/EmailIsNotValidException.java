package com.monocept.springdemo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailIsNotValidException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String errorMessage;
	
	public EmailIsNotValidException() {
		errorMessage="Email is Not Valid";
	}
	

}
