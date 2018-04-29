package com.sdp.web.jsoncontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sdp.exception.BaseException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ErrorController {
	// 处理自定义的异常
	@ExceptionHandler(BaseException.class)
	@ResponseBody
	public Map customHandler(BaseException e) {
		Map map = new HashMap();
		map.put("code", e.GetCode());
		map.put("msg", e.getMessage());
		return map;
	}

	// 其他未处理的异常
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map allHandler(Exception e) {
		Map map = new HashMap();
		map.put("code", 500);
		map.put("msg", e.toString());
		e.printStackTrace();
		return map;
	}
}
