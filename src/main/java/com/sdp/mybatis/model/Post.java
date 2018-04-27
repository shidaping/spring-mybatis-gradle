package com.sdp.mybatis.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
	private int id;
	@NotBlank()
	private String title;
	@NotBlank()
	private String content;
}
