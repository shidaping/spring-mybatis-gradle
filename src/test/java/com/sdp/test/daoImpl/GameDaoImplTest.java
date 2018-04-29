package com.sdp.test.daoImpl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.sdp.mybatis.dao.GameDaoImpl;
import com.sdp.mybatis.model.Game;
import com.sdp.web.jsoncontroller.game.ListReq;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,
    classes={com.sdp.config.SpringRootConfig.class})
public class GameDaoImplTest {
	@Autowired
	private GameDaoImpl gameDaoImpl;
	@Test
	public void list() {
		try{
			ListReq listReq = new ListReq();
//			listReq.setCompany(1);
//			listReq.setName("梦");
			int gameList =  gameDaoImpl.listCount(listReq);
			System.out.println(gameList);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void removeFavorite() {
		try{

		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}