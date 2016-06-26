package com.sdp.mybatis.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sdp.jsoncontroller.PostController;
import com.sdp.mybatis.model.Project;
import com.sdp.requestparam.ProjectListParam;

@Service
public class ProjectDaoImpl extends SqlSessionDaoSupport implements ProjectDao{
	private Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
	@Override
	public boolean createProject(Project project) {
		// TODO Auto-generated method stub
		int id=this.getSqlSession().insert("com.sdp.mybatis.dao.ProjectDao.createProject", project);
		logger.info(project.getId() + "");
		return true;
	}

	@Override
	public List<Project> getProjectList(ProjectListParam projectListParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProject(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Project getProject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
