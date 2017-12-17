package com.sdp.test.jedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,
    classes={com.sdp.config.SpringRootConfig.class})
public class JedisTest {
	@Autowired
	Jedis jedis;
	@Test
	public void testJedis() {
		jedis.set("test", "abc");
		System.out.println(jedis.get("test"));
	}
}
