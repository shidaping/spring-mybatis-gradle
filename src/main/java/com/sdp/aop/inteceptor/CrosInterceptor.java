package com.sdp.aop.inteceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdp.aop.annotation.LoginRequired;
import com.sdp.mybatis.dao.UserDaoImpl;
import com.sdp.mybatis.model.User;
import com.sdp.util.SessionUtil;

public class CrosInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(CrosInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (request.getMethod().toUpperCase().equals("OPTIONS")) {
        		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        		return false;
        } else {
    			return true;
        }

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

