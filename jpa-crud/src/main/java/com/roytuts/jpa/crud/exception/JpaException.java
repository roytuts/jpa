package com.roytuts.jpa.crud.exception;

public class JpaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JpaException(String msg) {
		super(msg);
	}

	public JpaException(Throwable t) {
		super(t);
	}

	public JpaException(String msg, Throwable t) {
		super(msg, t);
	}

}
