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
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdp.aop.annotation.LoginRequired;
import com.sdp.mybatis.dao.UserDaoImpl;
import com.sdp.mybatis.model.User;
import com.sdp.util.SessionUtil;

public class LoginInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	UserDaoImpl userDaoImpl;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
        if(loginRequired != null) {
            Map json = new HashMap();
            boolean error = false;
            SessionUtil sessionUtil = (SessionUtil) request.getAttribute("sessionUtil"); 
            System.out.println(sessionUtil);
            if(sessionUtil == null) {
            		error = true;
            		json.put("code", 1000);
                json.put("msg", "未登录");
            } else {
            		long userId = Long.parseLong(sessionUtil.get("id"));
            		User user;
            		if(loginRequired.type().equals("admin")) {
            			if(userId != 234) {
            				error = true;
                    		json.put("code", 1001);
                        json.put("msg", "权限不够");
            			}
            		}
            }
            if(error) {
    				PrintWriter writer = null;
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                try {
                    writer = response.getWriter();
                    ObjectMapper mapper = new ObjectMapper();
                    writer.print(mapper.writeValueAsString(json));
                } catch (IOException e) {
                    logger.error("response error",e);
                } finally {
                    if (writer != null)
                        writer.close();
                }
            } else {
            		
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
