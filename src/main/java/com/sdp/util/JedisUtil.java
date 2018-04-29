package com.sdp.util;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtil {
	private JedisPool jedisPool;
	private String auth;
	public JedisUtil(JedisPool jedisPool, String auth) {
		this.jedisPool = jedisPool;
		this.auth = auth;
	}
	public void set(String key, String value, int expire) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.auth(auth);
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
	public void delete(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.auth(auth);
			jedis.del(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}
	public String get(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.auth(auth);
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
