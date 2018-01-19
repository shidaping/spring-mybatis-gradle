package com.sdp.util;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {
	private JedisPool jedisPool;
	public JedisUtil(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	public void set(String key, String value, int expire) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.auth("dangerous");
			jedis.expire(key, expire);
			jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}
	public void set(String key, String value) {
		this.set(key, value, 24 * 60 * 60);
	}
	public String get(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.auth("dangerous");
			return jedis.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
		return null;
	}
}
