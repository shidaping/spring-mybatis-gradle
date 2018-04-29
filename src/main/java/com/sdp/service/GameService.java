package com.sdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.enumeration.ExceptionEnum;
import com.sdp.exception.BaseException;
import com.sdp.mybatis.dao.GameDaoImpl;
import com.sdp.mybatis.model.Game;
import com.sdp.mybatis.model.UserGame;

@Service
public class GameService {
	@Autowired
	private GameDaoImpl gameDaoImpl;
	public boolean addFavorite(long userId, long gameId ) throws BaseException {
		Game game = gameDaoImpl.getGameById(gameId);
		if(game == null) {
			throw new BaseException(ExceptionEnum.BUSINESS_ERROR, "gameId is not valid");
		}
		UserGame userGame = gameDaoImpl.getUserGame(userId, gameId);
		if(userGame != null) {
			throw new BaseException(ExceptionEnum.BUSINESS_ERROR, "gameId has beed added");
		}
		return gameDaoImpl.addFavorite(userId, gameId);
	}
	public boolean removeFavorite(long userId, long gameId ) throws BaseException {
		Game game = gameDaoImpl.getGameById(gameId);
		if(game == null) {
			throw new BaseException(ExceptionEnum.BUSINESS_ERROR, "gameId is not valid");
		}
		UserGame userGame = gameDaoImpl.getUserGame(userId, gameId);
		if(userGame == null) {
			throw new BaseException(ExceptionEnum.BUSINESS_ERROR, "gameId not added");
		}
		return gameDaoImpl.removeFavorite(userId, gameId);
	}
}
