package com.simphony.challenge.exception;

public class SimphonyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9147297638578891951L;

	public SimphonyException() {
	}
	
	public SimphonyException(String message) {
		super(message);
	}
	
	public SimphonyException(String message, Throwable exc) {
		super(message, exc);
	}
	
}
