package com.sdp.mybatis.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
	private long id;
	private String mobile;
	private String username;
	private String email;
	private String encodedPassword;
	private String salt;	
}
