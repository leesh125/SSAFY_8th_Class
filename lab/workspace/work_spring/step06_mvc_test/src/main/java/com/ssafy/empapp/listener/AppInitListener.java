package com.ssafy.empapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInitListener implements ServletContextListener {
	
    public void contextDestroyed(ServletContextEvent sce)  { }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application = sce.getServletContext();
		String root  = application.getContextPath();
		application.setAttribute("root", root);
		System.out.println("root set...");
    }
	
}
