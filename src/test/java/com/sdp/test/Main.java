package com.sdp.test;

import java.util.UUID;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;

import com.sdp.config.ServletInitializer;
import com.sdp.util.PasswordUtil;
import com.sdp.util.RegUtil;

public class Main {
	@Test
	public void test() {
//		ServletInitializer s = new ServletInitializer();
//		s.
//		String salt = UUID.randomUUID().toString().replace("-", "");  
//		System.out.println(salt);
//		try {
//			System.out.println(PasswordUtil.encodePassword("dangerous", salt));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		String username ="admin";
		SQL sql = new SQL(); 
		sql.FROM("user");
		if(RegUtil.match(RegUtil.REGEX_MOBILE, username)) {
			sql.WHERE("user.mobile=#{username}");
		} else if(RegUtil.match(RegUtil.REGEX_EMAIL, username)) {
			sql.WHERE("user.email=#{username}");
		} else {
			sql.WHERE("user.username=#{username}");
		}			
		System.out.println(sql.toString());
	}
}
