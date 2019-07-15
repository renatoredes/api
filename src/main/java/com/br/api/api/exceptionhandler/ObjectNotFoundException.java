package com.br.api.api.exceptionhandler;

public class ObjectNotFoundException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6359239883954483655L;

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
