package com.sdp.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.sdp.mybatis.model.Post;

public interface PostDao {
	@Insert("insert into post(title, content) values(#{title}, #{content})")  
	public boolean createPost(Post post);
	@Insert("insert into post(title, content) values(#{title}, #{content})")  
	public List<Post> getPostList();
	@Insert("insert into post(title, content) values(#{title}, #{content})")  
	public boolean deletePost(int id);
}
