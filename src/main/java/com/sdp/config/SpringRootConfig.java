package com.sdp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.sdp.mybatis.dao.PostDaoImpl;
import com.sdp.web.controller.IndexController;

import redis.clients.jedis.Jedis;

@Configuration
//@PropertySource("classpath:config.properties")
@PropertySource("classpath:config-${systemProperties['env']?systemProperties['env']:dev}.properties")
@ComponentScan({ "com.sdp.mybatis.**", "com.sdp.service.**", "com.sdp.util.**", "com.sdp.aop.inteceptor.**" })
@Import(value = {JedisConfig.class, MysqlConfig.class })
@EnableAspectJAutoProxy
public class SpringRootConfig  {
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
//	@Autowired
//	@Value("${db.url}")
//    private String env;
    //You need this
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }

}
