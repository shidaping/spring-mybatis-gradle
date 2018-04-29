package com.sdp.enumeration;


public enum MethodEnum {
	OTHER(9999, "其他"),
	HUI_HE(1, "回合制"),
	QI_PAI(2, "棋牌"),
	ROLE(3, "角色扮演"),
	TACTIC(4, "即时战略"),
	REMOVE(5, "削除类"),
	FLIGHT(6, "格斗");
	private int code;
	private String message;
	private MethodEnum(int code,String message) {
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
