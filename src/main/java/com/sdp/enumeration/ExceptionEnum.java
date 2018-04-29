package com.sdp.enumeration;

public enum ExceptionEnum {
	NOT_LOGIN(10001, "未登录"),
	NOT_AUTHORIZED(10002, "无权限"),
	WRONG_LOGIN(10003, "登录信息有误"),
	WRONG_PARAM(20001, "参数错误"),
	BUSINESS_ERROR(30001, "业务逻辑出错");
	
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
