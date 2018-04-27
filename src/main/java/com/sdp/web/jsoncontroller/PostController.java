package com.sdp.web.jsoncontroller;

import java.util.HashMap;
import java.util.Map;

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

import com.sdp.aop.annotation.LoginRequired;
import com.sdp.enumeration.ExceptionEnum;
import com.sdp.exception.BaseException;
import com.sdp.mybatis.dao.PostDaoImpl;
import com.sdp.mybatis.model.Post;
import com.sdp.util.ValidateUtil;

import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
public class PostController {
	@Autowired
	private PostDaoImpl postDaoImpl;
	@LoginRequired(type="admin")
	@RequestMapping(value="/post/create",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public Map create(Model model, HttpServletRequest request, HttpServletResponse response, @RequestBody Post post) throws BaseException {
		Map json=new HashMap();
		String validateResult = ValidateUtil.validate(post);
		if(validateResult != null) {
			log.error("验证结果：" + validateResult);
			throw new BaseException(ExceptionEnum.WRONG_PARAM, validateResult);
		}
		log.info(post.getTitle());
		log.info(post.getContent());
		postDaoImpl.createPost(post);
		json.put("error", false);
		json.put("data", post);
		return json;
	}
}

