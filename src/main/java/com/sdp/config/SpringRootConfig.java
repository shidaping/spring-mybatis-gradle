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
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.sdp.mybatis.dao.PostDaoImpl;
import com.sdp.web.controller.IndexController;

import redis.clients.jedis.Jedis;

@Configuration
@PropertySource("classpath:config.properties")
@ComponentScan({ "com.sdp.mybatis.**" })
@EnableAspectJAutoProxy
public class SpringRootConfig  {
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
//	@Autowired
    Environment env;
    @Value("#{systemProperties['DEPLOY_ENV']}")
    private String jdbcUrl;
	@Bean
	public BasicDataSource basicDataSource() {
		logger.error("env",jdbcUrl);
		System.out.println(env);
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//basicDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8");
		basicDataSource.setUrl(jdbcUrl);
		
		basicDataSource.setUsername("test");
		basicDataSource.setPassword("dangerous");
		return basicDataSource;
	}
	@Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(basicDataSource());
    }
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(basicDataSource());
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.addMappers("com.sdp.mybatis.dao");
		sqlSessionFactoryBean.setConfiguration(configuration );
		return sqlSessionFactoryBean;
	}
	@Bean
	public Jedis jedis() {
		Jedis jedis = new Jedis("118.31.6.61", 6379);
		jedis.auth("dangerous");
		return jedis;
	}
}
