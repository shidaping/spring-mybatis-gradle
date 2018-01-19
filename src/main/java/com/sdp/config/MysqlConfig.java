package com.sdp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.sdp.web.controller.IndexController;

@Configuration
public class MysqlConfig {
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Value("#{systemProperties['SDP_DEPLOY_ENV']}")
    private String jdbcUrl;
	@Bean
	public BasicDataSource basicDataSource() {
		logger.error("env",jdbcUrl);
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
}
