package com.cg.dms.exception;

public class CustomerAlreadyExistsException extends RuntimeException{  

	// if customer already exists, handles CustomerAlreadyExistsException exception
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6048204975685882709L;

	public CustomerAlreadyExistsException() {
		super();
	}
	
	public CustomerAlreadyExistsException(String s) {
		super(s);
	}
	
}
