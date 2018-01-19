package com.sdp.util;

import org.springframework.beans.factory.annotation.Autowired;

public class SessionUtil {
	private JedisUtil jedisUtil;
	private String sessionId;
	public SessionUtil(JedisUtil jedisUtil, String sessionId) {
		this.jedisUtil = jedisUtil;
		this.sessionId = sessionId;
	}
	public String get(String name) {
		return jedisUtil.get(sessionId + name);
	}
	public void set(String name, String value) {
		jedisUtil.set(sessionId + name, value);
	}
}
