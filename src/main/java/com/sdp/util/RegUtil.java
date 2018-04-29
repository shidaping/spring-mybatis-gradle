package com.sdp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegUtil {
    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
 
    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    
    public static boolean match(String reg, String value) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(value);
        return m.find();//boolean
    }

}
