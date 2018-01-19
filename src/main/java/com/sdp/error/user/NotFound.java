package com.sdp.error.user;

import java.util.HashMap;

public class NotFound extends HashMap<String,Object> {
	public NotFound() {
		this.put("code", 200002);
		this.put("msg", "用户不存在");
	}
}
