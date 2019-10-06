package com.codar.vendas.services.exceptions;

public class AuthorizationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AuthorizationException(String msg) {
		super(msg);
	}
	
	public AuthorizationException(String msg, Throwable couse ) {
		super(msg,couse);
	}
}
