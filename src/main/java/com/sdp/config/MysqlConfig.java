package com.sdp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.logging.log4j.Log4jImpl;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.sdp.web.controller.IndexController;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class MysqlConfig {
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Value("${db.url}")
    private String jdbcUrl;
    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.username}")
    private String dbUsername;
    @Value("${db.password}")
    private String dbPassword;
	@Bean
	public BasicDataSource basicDataSource() {
		System.out.println(jdbcUrl);
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driverClassName);
		//basicDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8");
		basicDataSource.setUrl(jdbcUrl);
		
		basicDataSource.setUsername(dbUsername);
		basicDataSource.setPassword(dbPassword);
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
		configuration.setMapUnderscoreToCamelCase(true);
		sqlSessionFactoryBean.setConfiguration(configuration);
		return sqlSessionFactoryBean;
	}
}
