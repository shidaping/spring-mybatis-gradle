package com.sdp.mybatis.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.sdp.jsoncontroller.PostController;
import com.sdp.mybatis.model.Project;
import com.sdp.mybatis.model.User;
import com.sdp.requestparam.ProjectListParam;

@Component
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{
	private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert("com.sdp.mybatis.dao.UserDao.createUser", user);
		return true;
	}
	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("com.sdp.mybatis.dao.UserDao.getUserByUserName", userName);
	}
	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("com.sdp.mybatis.dao.UserDao.getUserByEmail", email);
	}
	@Override
	public User getUserByMobile(String mobile) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("com.sdp.mybatis.dao.UserDao.getUserByUserName", mobile);
	}

}
