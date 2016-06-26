package com.sdp.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sdp.mybatis.model.Project;
import com.sdp.mybatis.model.User;
import com.sdp.requestparam.ProjectListParam;

public interface UserDao {
	@Insert(
		"insert into user"
		+ "(user_name,email,mobile,password,salt,nickname,true_name,avatar,score,level,user_type,created_by,created_at,updated_by,updated_at)"
		+ "values"
		+ "(#{user_name}, #{email},#{mobile},#{password},#{salt},#{nickname},#{true_name},#{avatar},#{score},#{level},#{user_type},#{created_by},#{created_at},#{updated_by},#{updated_at})"
	)  
	@Options(useGeneratedKeys=true, keyProperty="id")
	public boolean createUser(User user);
	@Select("select * from user where user_name=#{userName}")
	public User getUserByUserName(String userName);
	@Select("select * from user where email=#{email}")
	public User getUserByEmail(String email);
	@Select("select * from user where mobile=#{mobile}")
	public User getUserByMobile(String mobile);
	
}
