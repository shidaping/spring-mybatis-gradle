package com.sdp.web.jsoncontroller.user;

import java.util.HashMap;


import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdp.mybatis.model.Post;
import com.sdp.util.JedisUtil;
import com.sdp.web.jsoncontroller.PostController;

class LoginReq {
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(PostController.class);
	@Autowired
	private JedisUtil jedisUtil;
	@RequestMapping(value="/user/login",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public Map login(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody
			LoginReq loginReq) throws JsonProcessingException {
		Map json=new HashMap();
		if(loginReq.getUsername().isEmpty()) {
			return new com.sdp.error.NeedParam("缺少用户名");
		}
		if(loginReq.getPassword().isEmpty()) {
			return new com.sdp.error.NeedParam("缺少密码");
		}
		if(!loginReq.getUsername().equals("admin")) {
			return new com.sdp.error.user.NotFound();
		}
		if(!loginReq.getPassword().equals("admin")) {
			return new com.sdp.error.user.WrongPassword();
		}
		json.put("code", 0);
		// 写入redis
		String uuid = UUID.randomUUID().toString();
		ObjectMapper objectMapper = new ObjectMapper();
		String session = objectMapper.writeValueAsString(loginReq);
		jedisUtil.set(uuid + "id", "234");
		Cookie cookie = new Cookie("sessionId", uuid);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(24 * 60 * 60 * 1000);
		response.addCookie(cookie);
		return json;
	}
}
