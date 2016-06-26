package com.sdp.jsoncontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.mybatis.dao.PostDaoImpl;
import com.sdp.mybatis.dao.ProjectDaoImpl;
import com.sdp.mybatis.model.Post;
import com.sdp.mybatis.model.Project;
import com.sdp.requestparam.ProjectListParam;

@Controller
public class ProjectController {
	@Autowired
	private ProjectDaoImpl projectDaoImpl;
	private Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@RequestMapping(value = "/api/project/create", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public Map create(@RequestBody Project project) {

		Map json = new HashMap();
		String errMsg = null;
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Project>> constraintViolations = validator.validate(project);
		for (ConstraintViolation<Project> constraintViolation : constraintViolations) {
			errMsg = constraintViolation.getMessage();
			break;
		}
		if (errMsg != null) {
			json.put("error", true);
			json.put("code", 10000);
			json.put("msg", errMsg);
			return json;
		}

		if (projectDaoImpl.createProject(project)) {
			json.put("error", false);
			json.put("code", 0);
			json.put("data", project);
		} else {
			json.put("error", false);
			json.put("code", 30000);
			json.put("msg", "系统错误");
		}

		return json;
		// dd
	}
	@RequestMapping(value = "/api/project/list", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	public Map list(@RequestBody ProjectListParam projectListParam){
		Map json = new HashMap();
		projectDaoImpl.getProjectList(projectListParam);
		return json;
	}
}
