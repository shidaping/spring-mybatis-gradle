package com.sdp.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class PasswordUtil {
	public static final String prefix="a23cdd3d3awdsf";
	public static String encodePassword(String password, String salt) throws Exception {
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		return md5.encodePassword(password,prefix + salt);
//		return passwordEncoder.encodePassword(password, USER_PASSWORD_SALT_PREFIX + salt);
	}

	public static byte[] md5(String input) throws Exception {
		java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		byte[] result = md.digest(input.getBytes("UTF8"));
		return result;
	}

	public static byte[] sha256(String input) throws Exception {
		java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
		byte[] result = md.digest(input.getBytes("UTF8"));
		return result;
	}
}
