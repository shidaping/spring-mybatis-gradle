package com.sdp.test.service;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.sdp.mybatis.dao.UserDao;
import com.sdp.mybatis.model.User;
import com.sdp.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,
    classes={com.sdp.config.SpringRootConfig.class})
public class UserServiceTest {
	@Autowired
	private UserService userService;
	@Test
	public void getProductIdListUseIn() {
		try{
			User user = userService.login("admin","dangerous");
			System.out.println("aaaaaa");
			System.out.println(user.getEncodedPassword());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
