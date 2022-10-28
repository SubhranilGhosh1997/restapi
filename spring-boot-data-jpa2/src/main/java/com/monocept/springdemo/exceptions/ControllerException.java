package com.monocept.springdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="No user Found")
@AllArgsConstructor
@Getter
@Setter
public class ControllerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessageString;
	
	public ControllerException() {
		 System.out.println("Controller Exception");
	}
}
