package com.sdp.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.jsoncontroller.ProjectController;
import com.sdp.mybatis.dao.UserDao;
import com.sdp.mybatis.dao.UserDaoImpl;
import com.sdp.mybatis.model.User;
import com.sdp.util.PasswordUtil;

@Service
public class UserService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserDaoImpl userDaoImpl;
	public Map create(User user){
		Map json = new HashMap();
		String errMsg = null;
		//3:验证用户名或邮箱或手机唯一性
		if(user.getEmail()!=null){
			logger.info(user.getEmail());
			if(userDaoImpl.getUserByEmail(user.getEmail()) != null){
				errMsg="邮箱已经存在";
			}
		}
		if(user.getUser_name()!=null){
			if(userDaoImpl.getUserByUserName(user.getUser_name()) != null){
				errMsg="用户名已经存在";
			}
		}
		if(user.getMobile()!=null){
			if(userDaoImpl.getUserByMobile(user.getMobile()) != null){
				errMsg="手机号已经存在";
			}
		}
		if (errMsg != null) {
			json.put("error", true);
			json.put("code", 10000);
			json.put("msg", errMsg);
			return json;
		}


		userDaoImpl.createUser(user);
		json.put("error", false);
		json.put("code", 0);
		json.put("data", user);
		return json;
	}
	public Map login(User user) throws Exception{
		Map json = new HashMap();
		String errMsg = null;
		User dbUser = null;
		if (user.getUser_name() == null && user.getEmail() == null && user.getMobile() == null) {
			json.put("error", true);
			json.put("code", 10000);
			json.put("msg", "缺少用户名");
			return json;
		}
		if(user.getUser_name() != null){
			dbUser = this.userDaoImpl.getUserByUserName(user.getUser_name());
			if(dbUser == null){
				errMsg = "用户名不存在";
			}
		}else if(user.getEmail() !=null){
			dbUser = this.userDaoImpl.getUserByEmail(user.getEmail());
			if(dbUser == null){
				errMsg = "邮箱不存在";
			}
		}else if(user.getMobile() != null){
			dbUser = this.userDaoImpl.getUserByMobile(user.getMobile());
			if(dbUser == null){
				errMsg = "邮箱不存在";
			}
		}
		if(dbUser == null){
			json.put("error", true);
			json.put("msg", errMsg);
			json.put("code", 10000);
			return json;
		}
		String encodedPassword = PasswordUtil.encodePassword(user.getPassword(), dbUser.getSalt());
		logger.info(user.getPassword());
		logger.info(encodedPassword);
		logger.info(dbUser.getPassword());
		if(encodedPassword.equals(dbUser.getPassword())){

			json.put("error", false);
			json.put("code", 0);
			json.put("data", dbUser);
		}else{
			json.put("error", true);
			json.put("msg", "密码错误");
			json.put("code", 20000);
		}
		return json;
	}
}
