package com.movieFlex;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.movieFlex.springConfig.SpringRootConfig;
import com.movieFlex.springConfig.users.SpringUserConfig;

public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// root context
	    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
	    rootContext.register(SpringRootConfig.class);
	    servletContext.addListener(new ContextLoaderListener(rootContext));
	    
	    // Dispatcher Servlet 1: Users Servlet 
	    AnnotationConfigWebApplicationContext webContext1 = new AnnotationConfigWebApplicationContext();
	    webContext1.setParent(rootContext);
	    webContext1.register(SpringUserConfig.class);
	    ServletRegistration.Dynamic dispatcher1 = servletContext.addServlet("dispatcher1", new DispatcherServlet(webContext1));
	    dispatcher1.setLoadOnStartup(1);
	    dispatcher1.addMapping("/api/*");
	    
	}


}
