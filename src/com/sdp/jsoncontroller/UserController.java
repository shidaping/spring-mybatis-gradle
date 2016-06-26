package com.sdp.jsoncontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mybatis.dao.PostDaoImpl;
import com.sdp.mybatis.dao.ProjectDaoImpl;
import com.sdp.mybatis.dao.UserDaoImpl;
import com.sdp.mybatis.model.Post;
import com.sdp.mybatis.model.Project;
import com.sdp.mybatis.model.User;
import com.sdp.requestparam.ProjectListParam;
import com.sdp.service.UserService;
import com.sdp.util.PasswordUtil;

import java.util.UUID;

@Controller
public class UserController {
	@Autowired
	private UserService userServcie;
	private Logger logger = LoggerFactory.getLogger(UserController.class);

	/*
	 * 错误类型 10000:参数错误 20000: 逻辑错误 30000:系统错误
	 * 
	 */
	@RequestMapping(value = "/api/user/create", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public Map create(@RequestBody User user) throws Exception {
		logger.info(user.getPassword());
		logger.info(user.getEmail());
		String salt = UUID.randomUUID().toString();
		user.setSalt(salt);
		Map json = new HashMap();
		String errMsg = null;

		// 1:验证用户名或邮箱或手机至少存在一个
		if (user.getUser_name() == null && user.getEmail() == null && user.getMobile() == null) {
			json.put("error", true);
			json.put("code", 10000);
			json.put("msg", "缺少用户名");
			return json;
		}

		// 2:验证参数
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		for (ConstraintViolation<User> constraintViolation : constraintViolations) {
			errMsg = constraintViolation.getMessage();
			break;
		}
		String encodedPassword;

		encodedPassword = PasswordUtil.encodePassword(user.getPassword(), salt);

		user.setPassword(encodedPassword);
		
		return userServcie.create(user);
		// dd
	}

	@RequestMapping(value = "/api/user/login", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public Map login(@RequestBody User user) throws Exception {
		return userServcie.login(user);
	}
	@RequestMapping(value = "/api/user/get", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public Map list(@RequestBody User user) throws Exception {
		return userServcie.login(user);
	}
}
