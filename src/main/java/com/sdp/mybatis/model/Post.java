package com.sdp.mybatis.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
	private int id;
	private String title;
	private String content;
}
