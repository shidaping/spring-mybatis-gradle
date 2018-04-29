package com.sdp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sdp.util.JedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {
	@Value("${redis.auth}")
	private String auth;
	@Value("${redis.host}")
	private String host;
	@Value("${redis.port}")
	private int port;
	@Bean
	public JedisPool jedisPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(10);
		config.setMaxIdle(10000);
		config.setMaxWaitMillis(5000);
//		config.setTestOnBorrow(true);
//		config.setTestOnReturn(true);
		JedisPool jedisPool = new JedisPool(config, host, port);
		return jedisPool;
		
//		Jedis jedis = jedisPool.getResource();
//		jedis.auth("dangerous");
//		return jedis;
		
//		Jedis jedis = new Jedis("118.31.6.61", 6379);
//		jedis.auth("dangerous");
//		return jedis;
	}
	@Bean
	public JedisUtil jedisUtil() {
		System.out.println("jeditUtil init");
		return new JedisUtil(this.jedisPool(), auth);
	}
}
