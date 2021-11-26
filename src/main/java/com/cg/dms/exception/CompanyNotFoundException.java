package com.cg.dms.exception;

public class CompanyNotFoundException extends Exception {   // if company not found handles this userdefined Exception

	/**
	 * 
	 */
	private static final long serialVersionUID = -480618119537359581L;

	public CompanyNotFoundException() {
		super();
	}
	
	public CompanyNotFoundException(String s) {
		super(s);
	}
}
