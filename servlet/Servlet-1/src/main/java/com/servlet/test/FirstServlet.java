package com.servlet.test;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class FirstServlet implements Servlet{

	// Overriding life cycle methods
	// Life cycle methods : init(ServletConfig) , service(ServletRequest req , ServletResponse res)
	// And destroy()
	
	ServletConfig config;
	
	@Override
	public void init(ServletConfig config) {
		this.config = config;
		System.out.println("Creating Object");
	}
	
	@Override
	public void service(ServletRequest req , ServletResponse res) throws ServletException , IOException{
		System.out.println("Servicing");
		
		// setting content type
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.println("<h1>Servlet Executed Successfully</h1>");
		out.println("<h2>Todays Date and time is : " + new Date().toString() + "</h2>");
		
	}
	
	@Override
	public void destroy() {
		config = null;
		System.out.println("Releasing resources");
	}
	
	// Non life cycle methods
	// getServletConfig
	// getServletInfo
	
	@Override
	public ServletConfig getServletConfig() {
		return config;
	}
	
	@Override
	public String getServletInfo() {
		return "This servlet is created by Niraj randhir";
	}
}

/*
 INFO: Server startup in [882] milliseconds
Creating Object				//INIT METHOD CALLED WHEN RAN ON SERVER
Servicing			//SERVICE METHOD SECOND
Oct 15, 2024 8:03:47 PM org.apache.catalina.core.StandardServer await
INFO: A valid shutdown command was received via the shutdown port. Stopping the Server instance.
Oct 15, 2024 8:03:47 PM org.apache.coyote.AbstractProtocol pause
INFO: Pausing ProtocolHandler ["http-nio-8080"]
Oct 15, 2024 8:03:47 PM org.apache.catalina.core.StandardService stopInternal
INFO: Stopping service [Catalina]
Releasing resources		// AFTER STOPPING SERVER DESTROY METHOD IS CALLED
Oct 15, 2024 8:03:47 PM org.apache.coyote.AbstractProtocol stop
  */
