package com.blog.post.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.blog.post.service.AuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select username,password, enabled from user where username=?")
		.authoritiesByUsernameQuery(
			"select username, authority from authority where username=?");
	
	}	
	
	@Bean
	public SpringAuthenticationProvider springAuthenticationProvider() {
		return new SpringAuthenticationProvider();
	}
	
	@Bean
	public AuthenticationService springDataUserDetailsService() {
		return new AuthenticationService();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
	  //.anyRequest().permitAll()
	  	.antMatchers("/login","/register/**", "/resources/**").permitAll()
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
		//.antMatchers("/**").hasAnyRole("USER", "ADMIN")
		.anyRequest().authenticated() 
		.and()
		  .formLogin().loginPage("/login").failureUrl("/login?error")
		  .usernameParameter("userName").passwordParameter("password")
		.and()
		  .logout().logoutSuccessUrl("/login?logout")
		.and()
		  .exceptionHandling().accessDeniedPage("/403")
		.and()
		  .csrf().disable();
	}
	

	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests()
	    	.antMatchers("/login","/register", "/resources/**").permitAll()
	    	.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") 	
	    	.antMatchers("/**").hasAnyRole("USER", "ADMIN")
	    	.anyRequest().authenticated()
	    	.and().formLogin()
			.loginPage("/login").failureUrl("/login?error").permitAll()
			.and().logout().logoutSuccessUrl("/login?logout").permitAll()
			.and().exceptionHandling().accessDeniedPage("/403")
			.and().csrf().disable();
	}*/
}
