package com.ysf.local.cucumberImplementataion.common;

public class AccountException extends Exception {

	private String message;
	private int code;
	
	public AccountException( ) {
		super("Invalid account");
	}
	
	public AccountException(String message ) {
		super(message);
		this.message = message;
	}
	
	public AccountException(String message ,int code) {
		super(message);
		this.message = message;
		this.code = code;
	}
	
	
	
	
}
