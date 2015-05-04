package com.sourceit.survey.exceptions;

public class CommonException extends Exception {
	private static final long serialVersionUID = 7803484175197842231L;

	public CommonException(String message) {
		super(message);
	}

	public CommonException(Throwable cause) {
		super(cause);
	}

	public CommonException(String message, Throwable cause) {
		super(message, cause);
	}
}
