package com.sdp.error;

import java.util.HashMap;

public class NeedParam extends HashMap<String, Object>{
	public NeedParam(String message) {
		this.put("coce", 10000);
		this.put("msg", message);
	}
}
