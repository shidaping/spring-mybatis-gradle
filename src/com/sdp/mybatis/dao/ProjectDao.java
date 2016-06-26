package com.sdp.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sdp.mybatis.model.Project;
import com.sdp.requestparam.ProjectListParam;

public interface ProjectDao {
	@Insert("insert into project(name,description,program_language,created_by,created_at,updated_by,updated_at) values(#{name}, #{description},#{program_language},#{created_by},#{created_at},#{updated_by},#{updated_at})")  
	@Options(useGeneratedKeys=true, keyProperty="id")
	public boolean createProject(Project project);
	@Select("select * from project limit $")
	public List<Project> getProjectList(ProjectListParam projectListParam);
	@Select("select * from project where id=#{id}")
	public Project getProject(int id);
	@Insert("insert into post(title, content) values(#{title}, #{content})")  
	public boolean deleteProject(int id);
}
