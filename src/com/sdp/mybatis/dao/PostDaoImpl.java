package com.sdp.mybatis.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.mybatis.model.Post;

@Service
public class PostDaoImpl extends SqlSessionDaoSupport implements PostDao{
	@Override
	public boolean createPost(Post post) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert("com.sdp.mybatis.dao.PostDao.createPost", post);
		return false;
	}

	@Override
	public List<Post> getPostList() {
		// TODO Auto-generated method stub
		this.getSqlSession().selectList("com.sdp.mybatis.dao.PostDao");
		return null;
	}

	@Override
	public boolean deletePost(int id) {
		this.getSqlSession().delete("main.java.com.sdp.mybatis.dao.PostDao");
		// TODO Auto-generated method stub
		return false;
	}
	
}
