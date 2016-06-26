package com.sdp.exception;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.privilegedactions.NewJaxbContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

public class SpringExceptionHandler implements HandlerExceptionResolver {
	private Logger logger = LoggerFactory.getLogger(SpringExceptionHandler.class);

	@Override
	@ResponseBody
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		// TODO Auto-generated method stub
		e.printStackTrace();
		response.setCharacterEncoding("utf-8");
		MappingJackson2JsonView m = new MappingJackson2JsonView();
		m.addStaticAttribute("error", true);
		m.addStaticAttribute("msg", e.getMessage());
		m.addStaticAttribute("code", 30000);
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.setView(m);
		return modelAndView;
	}

}
