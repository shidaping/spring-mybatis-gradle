package com.sdp.mybatis.model;
import java.sql.Date;

import org.hibernate.validator.constraints.NotBlank;

public class Project {
	private int id;
	@NotBlank(message="名称不能为空")
	private String name;
	@NotBlank(message="描述不能为空")
	private String description;
	private String program_language;
	private int created_by;
	private Date created_at;
	private int updated_by;
	private Date updated_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProgram_language() {
		return program_language;
	}
	public void setProgram_language(String program_language) {
		this.program_language = program_language;
	}
	public int getCreated_by() {
		return created_by;
	}
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public int getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(int updated_by) {
		this.updated_by = updated_by;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

}
