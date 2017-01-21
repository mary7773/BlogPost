package com.blog.post.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@Configuration
@EnableAsync
@ComponentScan("com.blog.post")
@Import({ ApplicationContext.class, MailConfig.class, SecurityConfig.class })
@PropertySource("classpath:db.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/index").setViewName("listPosts");
		registry.addViewController("/newpost").setViewName("newpost");
		registry.addViewController("/contact").setViewName("contact");
		registry.addViewController("/about").setViewName("about");
		registry.addViewController("/admin").setViewName("admin/admin");
		registry.addViewController("/403").setViewName("403");
		

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfig() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public InternalResourceViewResolver internalResolver() {
		InternalResourceViewResolver intern = new InternalResourceViewResolver();
		intern.setPrefix("/WEB-INF/views/");
		intern.setSuffix(".jsp");
		return intern;
	}

	
}
