package com.sdp.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@EnableWebMvc //<mvc:annotation-driven />
@Configuration
@ComponentScan({ "com.sdp.web.controller", "com.sdp.web.jsoncontroller" })
public class SpringWebConfig extends WebMvcConfigurerAdapter {
	// @Override
	// public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// 	registry.addResourceHandler("/resources/**")
 //                        .addResourceLocations("/resources/");
	// }

//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver
//                         = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/templates");
//		viewResolver.setSuffix(".html");
//		return viewResolver;
//	}

	@Bean(name = "viewResolver")
	public ViewResolver velocityViewResolver() {
		VelocityViewResolver velocityViewResolver = new VelocityViewResolver();
		velocityViewResolver.setCache(false);
		velocityViewResolver.setSuffix(".html");
		velocityViewResolver.setContentType("text/html; charset=UTF-8");
		return velocityViewResolver;
	}
	@Bean(name = "velocityConfig")
	public VelocityConfigurer velocityConfigurer() {
		VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
		velocityConfigurer.setResourceLoaderPath("classpath:/templates/");
		Properties velocityProperties = new Properties();
		velocityProperties.put("output.encoding", "UTF-8");
		velocityProperties.put("input.encoding", "UTF-8");
		
		velocityConfigurer.setVelocityProperties(velocityProperties);
		return velocityConfigurer;
		
	}
	
	@Bean
	public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
		List<HttpMessageConverter<?>> messageConverters = new ArrayList();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
		messageConverters.add(mappingJackson2HttpMessageConverter);
		RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
		requestMappingHandlerAdapter.setMessageConverters(messageConverters);
		return requestMappingHandlerAdapter;
	}
}
