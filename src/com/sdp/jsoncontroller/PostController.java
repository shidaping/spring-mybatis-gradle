package com.sdp.jsoncontroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mybatis.dao.PostDaoImpl;
import com.sdp.mybatis.model.Post;
@Controller
public class PostController {
	@Autowired
	private PostDaoImpl postDaoImpl;
	private Logger logger = LoggerFactory.getLogger(PostController.class);
	@RequestMapping(value="/json/post/create.json",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public Map login(Model model, HttpServletRequest request, HttpServletResponse response) {
		Map json=new HashMap();
		Post newPost = new Post();
		newPost.setTitle("sdafsadfasdf");
		newPost.setContent("sadfsadfd");
		logger.info(newPost.getTitle());
		logger.info(newPost.getContent());
		if(postDaoImpl.createPost(newPost)){
			json.put("error", false);
			json.put("data", newPost);
		}else{
			json.put("error", false);
			json.put("code", "10000");
			json.put("msg", "asdfasdf");
			json.put("data", newPost);
		}

		
		return json;
		// dd
	}
}

