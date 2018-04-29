package com.sdp.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.enumeration.ExceptionEnum;
import com.sdp.exception.BaseException;
import com.sdp.mybatis.dao.GameDaoImpl;
import com.sdp.mybatis.dao.UserDaoImpl;
import com.sdp.mybatis.model.Game;
import com.sdp.mybatis.model.User;
import com.sdp.mybatis.model.UserGame;
import com.sdp.util.PasswordUtil;
import com.sdp.util.RegUtil;

@Service
public class UserService {
	@Autowired
	private UserDaoImpl userDaoImpl;
	public User login(String username, String password) throws BaseException, Exception {
		User user = userDaoImpl.getUserByUsername(username);
		if(user == null) {
			throw new BaseException(ExceptionEnum.BUSINESS_ERROR, "username is invalid");
		}
		if(!user.getEncodedPassword().equals(PasswordUtil.encodePassword(password, user.getSalt()))) {
			throw new BaseException(ExceptionEnum.BUSINESS_ERROR, "password is invalid");
		}
		return user;
		
	}
}
