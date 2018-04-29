package com.sdp.mybatis.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sdp.mybatis.model.Game;
import com.sdp.mybatis.model.UserGame;
import com.sdp.web.jsoncontroller.game.ListReq;

@Service
public class GameDaoImpl extends BaseDaoImpl implements GameDao {

	@Override
	public boolean addFavorite(long userId, long gameId) {
		Map params = new HashMap();
		params.put("userId", userId);
		params.put("gameId", gameId);
		this.getSqlSession().insert("com.sdp.mybatis.dao.GameDao.addFavorite", params );
		return true;
	}

	@Override
	public Game getGameById(long id) {
		return this.getSqlSession().selectOne("com.sdp.mybatis.dao.GameDao.getGameById", id);
	}

	@Override
	public UserGame getUserGame(long userId, long gameId) {
		Map params = new HashMap();
		params.put("userId", userId);
		params.put("gameId", gameId);
		return this.getSqlSession().selectOne("com.sdp.mybatis.dao.GameDao.getUserGame", params );

	}

	@Override
	public boolean removeFavorite(long userId, long gameId) {
		Map params = new HashMap();
		params.put("userId", userId);
		params.put("gameId", gameId);
		int result = this.getSqlSession().delete("com.sdp.mybatis.dao.GameDao.removeFavorite", params );
		if(result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public List<Game> list(ListReq listReq) {
		return this.getSqlSession().selectList("com.sdp.mybatis.dao.GameDao.list", listReq);
	}

	@Override
	public int listCount(ListReq listReq) {
		int a = this.getSqlSession().selectOne("com.sdp.mybatis.dao.GameDao.listCount", listReq);
		return a;
	}

}
