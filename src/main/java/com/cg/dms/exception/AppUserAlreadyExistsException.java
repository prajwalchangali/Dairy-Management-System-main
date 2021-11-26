package com.cg.dms.exception;

public class AppUserAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1824353607844877956L;

	public AppUserAlreadyExistsException() {
		super();
	}
	
	public AppUserAlreadyExistsException(String s) {
		super(s);
	}
}
