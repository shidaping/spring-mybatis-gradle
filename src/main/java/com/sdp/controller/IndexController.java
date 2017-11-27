package com.sdp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private Logger logger = LoggerFactory.getLogger(IndexController.class);

	@RequestMapping("/")
	public String login(Model model, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("asdfdaf");
		System.out.println("ddd");
		logger.info("this is info");
		logger.debug("this is debug");
		logger.warn("this is warn");
		logger.error("this is error");
		return "index";
		// dd
	}
}
