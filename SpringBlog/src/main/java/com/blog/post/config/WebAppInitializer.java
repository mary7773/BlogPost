package com.blog.post.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();		
		rootContext.register(WebConfig.class);
		
		context.setInitParameter("spring.profiles.active", "live");
		
		context.addListener(new ContextLoaderListener(rootContext));
		
		DelegatingFilterProxy filter = new DelegatingFilterProxy("springSecurityFilterChain");
		
		
		DispatcherServlet dispacher = new DispatcherServlet(rootContext);
		
       ServletRegistration.Dynamic registration = 	context.addServlet("dispacher", dispacher);
       
       context.addFilter("springSecurityFilterChain", filter).addMappingForUrlPatterns(null, false, "/*");
       registration.setLoadOnStartup(1);
       registration.addMapping("/");
	}

}
