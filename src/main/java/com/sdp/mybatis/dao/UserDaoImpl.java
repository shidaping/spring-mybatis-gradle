package com.sdp.mybatis.dao;

import org.springframework.stereotype.Service;

import com.sdp.mybatis.model.User;

@Service
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		this.getSqlSession().selectOne("com.sdp.mybatis.dao.UserDao.getUserById", id);
		return null;
	}
}
