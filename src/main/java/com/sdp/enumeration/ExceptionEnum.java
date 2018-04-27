package com.sdp.enumeration;

public enum ExceptionEnum {
	NOT_LOGIN(10001, "未登录"),
	NOT_AUTHORIZED(10001, "无权限"),
	WRONG_PARAM(20001, "参数错误");
	private int code;
	private String message;
	private ExceptionEnum(int code,String message) {
		this.code = code;
		this.message = message;
	};
	public int getCode() {
		return this.code;
	}
	
	public String getMessage() {
		return this.message;
	}
}
