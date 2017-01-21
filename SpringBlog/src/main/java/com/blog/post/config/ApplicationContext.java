package com.blog.post.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.blog.post.service.AuthorityService;
import com.blog.post.service.EmailService;
import com.blog.post.service.PostService;
import com.blog.post.service.UserService;
import com.blog.post.sevice.impl.AuthorityServiceImpl;
import com.blog.post.sevice.impl.EmailServiceImpl;
import com.blog.post.sevice.impl.PostServiceImpl;
import com.blog.post.sevice.impl.UserServiceImpl;

@Configuration
@EnableJpaRepositories(basePackages={"com.blog.post.repository"})
@EnableTransactionManagement
public class ApplicationContext {

	@Autowired
	private Environment environment;
	
	
	@Autowired
	@Bean(name = "postService")
	public PostService getPost() {
		return new PostServiceImpl();
	}
	
	@Autowired
	@Bean(name = "mailService")
	public EmailService getEmail() {
		return new EmailServiceImpl();
	}
	
	@Autowired
	@Bean(name = "userService")
	public UserService getUser() {
		return new UserServiceImpl();
	}


	@Autowired
	@Bean(name = "authorityService")
	public AuthorityService getAuthority() {
		return new AuthorityServiceImpl();
	}


	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("db.driver"));
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));
		return dataSource;
	}
	
	
	@Bean(name="transactionManager")
	public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManager){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManager);
		return jpaTransactionManager;
	}
	
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setShowSql(true);
		//jpaVendorAdapter.setGenerateDdl(true);
		
		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean localEntityManager = new LocalContainerEntityManagerFactoryBean();
		localEntityManager.setDataSource(dataSource());
		localEntityManager.setJpaVendorAdapter(jpaVendorAdapter());
		localEntityManager.setPackagesToScan("com.blog.post.model");
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		
		localEntityManager.setJpaProperties(jpaProperties);
				
		return localEntityManager;

	}
}
