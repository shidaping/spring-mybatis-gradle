package com.sdp.mybatis.model;

import java.sql.Date;

import javax.validation.constraints.Pattern;

import org.apache.ibatis.annotations.ResultMap;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonSetter;

public class User {
	private int id;
	@Email(message = "邮箱格式不正确")
	private String email;
	private String user_name;
	@Pattern(regexp = "^[1][0-9]{10}$", message = "手机格式不正确")
	private String mobile;
	@NotBlank(message = "密码不能为空")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@NotBlank(message = "盐不能为空")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String salt;
	private String nickname;
	private String true_name;
	private String level;
	private int score;
	private String avatar;
	@Range(min = 0, max = 2)
	private int user_type;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getTrue_name() {
		return true_name;
	}

	public void setTrue_name(String true_name) {
		this.true_name = true_name;
	}

}
