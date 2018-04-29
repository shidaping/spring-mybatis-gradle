package com.sdp.web.jsoncontroller.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdp.aop.annotation.LoginRequired;
import com.sdp.exception.BaseException;
import com.sdp.mybatis.dao.GameDaoImpl;
import com.sdp.mybatis.model.Game;
import com.sdp.service.GameService;
import com.sdp.util.JedisUtil;
import com.sdp.util.SessionUtil;
import com.sdp.util.ValidateUtil;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
class favoriteReq{
	@NotNull
	long gameId;
}

@Slf4j
@Controller
public class GameController {
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
	private GameService gameService; 
	@Autowired
	private GameDaoImpl gameDaoImpl;
	@RequestMapping(value = "/api/game/list", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public Map login(Model model, HttpServletRequest request, HttpServletResponse response, @RequestBody ListReq listReq)
			throws JsonProcessingException {
		List<Game> list = gameDaoImpl.list(listReq);
		int count  = gameDaoImpl.listCount(listReq);
		Map json = new HashMap();
		json.put("code", 0);
		json.put("count", count);
		json.put("result", list);
		return json;
	}
	@LoginRequired
	@RequestMapping(value = "/api/game/addFavorite", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public Map addFavorite(Model model, HttpServletRequest request, HttpServletResponse response, @RequestBody favoriteReq favoriteReq)
			throws JsonProcessingException, BaseException {
		Map json=new HashMap();
		ValidateUtil.validate(favoriteReq);
		SessionUtil sessionUtil = (SessionUtil) request.getAttribute("sessionUtil");
		gameService.addFavorite(Long.parseLong(sessionUtil.get("id")), favoriteReq.gameId);
		json.put("code", 0);
		return json;
	}
	@LoginRequired
	@RequestMapping(value = "/api/game/removeFavorite", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public Map removeFavorite(Model model, HttpServletRequest request, HttpServletResponse response, @RequestBody favoriteReq favoriteReq)
			throws JsonProcessingException, BaseException {
		Map json=new HashMap();
		ValidateUtil.validate(favoriteReq);
		SessionUtil sessionUtil = (SessionUtil) request.getAttribute("sessionUtil");
		gameService.removeFavorite(Long.parseLong(sessionUtil.get("id")), favoriteReq.gameId);
		json.put("code", 0);
		return json;
	}
}
