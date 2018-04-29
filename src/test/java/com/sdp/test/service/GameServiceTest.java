package com.sdp.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.sdp.mybatis.model.User;
import com.sdp.service.GameService;
import com.sdp.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,
    classes={com.sdp.config.SpringRootConfig.class})
public class GameServiceTest {
	@Autowired
	private GameService gameService;

	public void addFavorite() {
		try{
			gameService.addFavorite(1, 1);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	@Test
	public void removeFavorite() {
		try{
			gameService.removeFavorite(1, 1);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
