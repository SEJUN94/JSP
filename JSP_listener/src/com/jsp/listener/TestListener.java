package com.jsp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


public class TestListener implements ServletContextListener {


	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         System.out.println("TestListener loading !!!!!");
         
         String message = event.getServletContext().getInitParameter("message");
         System.out.println(message);
         
    }
	
}
