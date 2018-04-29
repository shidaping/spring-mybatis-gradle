package com.sdp.web.jsoncontroller.user;

import java.util.HashMap;


import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.constraints.NotBlank;
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
import com.sdp.exception.BaseException;
import com.sdp.mybatis.model.Post;
import com.sdp.mybatis.model.User;
import com.sdp.service.UserService;
import com.sdp.util.CookieUtil;
import com.sdp.util.JedisUtil;
import com.sdp.util.ValidateUtil;
import com.sdp.web.jsoncontroller.PostController;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
class LoginReq {
	@NotBlank
	private String username;
	@NotBlank
	private String password;
}

@Controller
@Slf4j
public class LoginController {
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
	private UserService userService;
	@RequestMapping(value="/api/user/login",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public Map login(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestBody
			LoginReq loginReq) throws JsonProcessingException, BaseException, Exception {
		ValidateUtil.validate(loginReq);
		User user = userService.login(loginReq.getUsername(), loginReq.getPassword());
		Map json=new HashMap();
		json.put("code", 0);
		json.put("result", user);
		// 写入redis
		String uuid = UUID.randomUUID().toString();
		jedisUtil.set(uuid + "id", String.valueOf(user.getId()));
		String oldSessionId = jedisUtil.get(String.valueOf(user.getId()));
		if(oldSessionId != null && !oldSessionId.isEmpty()) {
			jedisUtil.delete(oldSessionId + "*");
		}
		jedisUtil.set(String.valueOf(user.getId()), uuid);
		Cookie cookie = new Cookie("sessionId", uuid);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(24 * 60 * 60 * 1000);
		response.addCookie(cookie);
		return json;
	}
	@RequestMapping(value="/api/user/logout",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public Map logout(
			Model model,
			HttpServletRequest request,
			HttpServletResponse response
			) throws JsonProcessingException, BaseException, Exception {
		Map json=new HashMap();
		json.put("code", 0);
		Cookie[] cookies = request.getCookies();
		String sessionId = CookieUtil.get(cookies, "sessionId").getValue();
		jedisUtil.delete(sessionId + "*");
		Cookie cookie = new Cookie("sessionId", null);
		cookie.setPath("/");
		cookie.setHttpOnly(true);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return json;
	}
}
