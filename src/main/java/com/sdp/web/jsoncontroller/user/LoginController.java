package com.sdp.web.jsoncontroller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mybatis.model.Post;
import com.sdp.web.jsoncontroller.PostController;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(PostController.class);
	@RequestMapping(value="user/login",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public Map login(Model model, HttpServletRequest request, HttpServletResponse response) {
		Map json=new HashMap();
		Post newPost = new Post();
		logger.info(newPost.getTitle());
		logger.info(newPost.getContent());
		

		
		return json;
	}
}
