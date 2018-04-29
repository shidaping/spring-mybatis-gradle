package com.sdp.mybatis.dao;

import org.springframework.stereotype.Service;

import com.sdp.mybatis.model.User;

@Service
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
	@Override
	public User getUserById(long id) {
		return this.getSqlSession().selectOne("com.sdp.mybatis.dao.UserDao.getUserById", id);
	}

	@Override
	public User getUserByUsername(String username) {
		return this.getSqlSession().selectOne("com.sdp.mybatis.dao.UserDao.getUserByUsername", username);
	}
}
