package com.airline.controllers;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.airline.models.passenger;
/**
 * Application Lifecycle Listener implementation class AirlineListener
 *
 */
@WebListener
public class AirlineListener  implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public AirlineListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent events)  { 
         

    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent events)  { 
    	ServletContext sc= events.getServletContext();
    	
    	ArrayList<passenger>plist = (ArrayList<passenger>) sc.getAttribute("passenger");
    	
    	if(plist == null){
    		
    		System.out.println("No passenger list created yet. Let's create the list here...");
    		
    		plist = new ArrayList<passenger>(); 
    		
    		
    		
    		sc.setAttribute("passenger",plist);
    		
    	}
    }
	
}
