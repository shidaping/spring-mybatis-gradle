package com.sdp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.sdp.mybatis.dao.PostDaoImpl;
import com.sdp.web.controller.IndexController;

@Configuration
@ComponentScan({ "com.sdp.mybatis.**" })
public class SpringRootConfig  {
	private Logger logger = LoggerFactory.getLogger(IndexController.class);
	@Bean
	public BasicDataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		basicDataSource.setUrl("jdbc:mysql://118.31.6.61:3306/test?useUnicode=true&amp;characterEncoding=utf-8");
		basicDataSource.setUsername("test");
		basicDataSource.setPassword("dangerous");
		return basicDataSource;
	}
	@Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(basicDataSource());
    }
	@Bean()
	public SqlSessionFactoryBean sqlSessionFactoryBean() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(basicDataSource());
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.addMappers("com.sdp.mybatis.dao");
		sqlSessionFactoryBean.setConfiguration(configuration );
//		sqlSessionFactoryBean.setConfigLocation(new Resource().getFile("classpath:mybatis-config.xml"));
		return sqlSessionFactoryBean;
	}
//	@Bean
//	public PostDaoImpl postDaoImpl() throws Exception {
//		PostDaoImpl postDaoImpl = new PostDaoImpl(sqlSessionFactoryBean());
//		postDaoImpl.setSqlSessionFactory(sqlSessionFactoryBean());
//		logger.info("aaaaaa",postDaoImpl.getSqlSession());
//		return postDaoImpl;
//	}
	//org.mybatis.spring.SqlSessionFactoryBean
	//org.apache.commons.dbcp2.BasicDataSource
}
