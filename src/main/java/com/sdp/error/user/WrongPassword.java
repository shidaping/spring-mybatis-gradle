package com.sdp.error.user;

import java.util.HashMap;

public class WrongPassword extends HashMap<String,Object>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 541700014105870709L;

	public WrongPassword() {
		this.put("code", 200003);
		this.put("msg", "密码错误");
	}
}
