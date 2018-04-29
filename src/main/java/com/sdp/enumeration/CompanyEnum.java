package com.sdp.enumeration;

public enum CompanyEnum {
	OTHER(9999, "其他"),
	TECENT(1, "腾讯"),
	NETEASE(2, "网易"),
	SOHU(3, "搜狐畅游"),
	DUOYI(4, "多益"),
	SHENGDA(4, "盛大");
	private int code;
	private String message;
	private CompanyEnum(int code,String message) {
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
