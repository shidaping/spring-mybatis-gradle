package com.sdp.test.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.sdp.util.JedisUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,
    classes={com.sdp.config.SpringRootConfig.class})
public class JedisTest {
	@Autowired
	JedisUtil jedisUtil;
	@Test
	public void testJedis() {
		System.out.println(jedisUtil.get("bb"));
//		jedis.ping();
//		jedis.set("test", "abc");
//		System.out.println(jedis.get("test"));
//		Jedis jedis = null;
//		try {
//			jedis = jedisPool.getResource();
//			jedis.auth("dangerous");
//			jedis.set("bb", "aa");
//			System.out.println(jedis.get("bb"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(jedis != null) {
//				jedis.close();
//			}
//		}
	}
}
