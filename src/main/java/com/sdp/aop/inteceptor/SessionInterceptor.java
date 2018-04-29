package com.sdp.aop.inteceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sdp.enumeration.ExceptionEnum;
import com.sdp.exception.BaseException;
import com.sdp.util.CookieUtil;
import com.sdp.util.JedisUtil;
import com.sdp.util.SessionUtil;
import com.sdp.web.controller.IndexController;

@Service
public class SessionInterceptor implements HandlerInterceptor {
	@Autowired
	JedisUtil jedisUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception, BaseException {
		// TODO Auto-generated method stub
		Cookie[] cookies = request.getCookies();
		String sessionId = CookieUtil.get(cookies, "sessionId").getValue();
		if(!sessionId.isEmpty()) {
			if(!jedisUtil.get(sessionId + "id").isEmpty()) {
				SessionUtil sessionUtil = new SessionUtil(jedisUtil, sessionId);
				request.setAttribute("sessionUtil", sessionUtil);
			}else {
				Cookie cookie = new Cookie("sessionId", "");
				cookie.setPath("/");
				cookie.setHttpOnly(true);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				throw new BaseException(ExceptionEnum.WRONG_LOGIN, "");
			}
		}		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
