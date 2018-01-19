package com.sdp.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.sdp.mybatis.model.User;

public interface UserDao {
	@Select("select * from user where id=#{id}")
	public User getUserById(long id);
}
