package com.sdp.enumeration;

public enum EngineEnum {
	OTHER(9999, "其他"),
	UNITY(1, "unity"),
	UNREAL(2, "unreal"),
	COCOS(3, "cocos");
	private int code;
	private String message;
	private EngineEnum(int code,String message) {
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
