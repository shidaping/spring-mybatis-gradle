package com.sdp.test.jackson;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;

class TestObj {
	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}	
}

public class JacksonTest {
	@Test
	public void testJackson() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HashMap t = mapper.readValue("{\"a\":{}}", HashMap.class);
		System.out.println(t.get("a"));
		TestObj t2 = new TestObj();
		t2.setA("asdf");
		System.out.println(mapper.writeValueAsString(t2));

				
	}
}
