package com.sdp.exception;

import com.sdp.enumeration.ExceptionEnum;

public class BaseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8289826906371695409L;
	private ExceptionEnum exceptionEnum;
	private String extraMessage;
	public BaseException(ExceptionEnum exceptionEnum, String extraMessage) {
		this.exceptionEnum = exceptionEnum;
		this.extraMessage = extraMessage;
	}
	public int GetCode() {
		return this.exceptionEnum.getCode();
	}
	@Override
	public String getMessage() {
		return this.exceptionEnum.getMessage() + this.extraMessage;
	}
}
