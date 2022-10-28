package com.monocept.springdemo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NoStudentException extends Exception {
	private static final long serialVersionUID = 1L;

	private String errorCode;
	private String errorMessage;
	
	public NoStudentException() {
		errorMessage="No Student Found";
		 System.out.println("Student Not Found");
	}
}
