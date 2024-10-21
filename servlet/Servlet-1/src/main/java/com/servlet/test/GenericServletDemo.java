package com.servlet.test;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.*;
import java.io.PrintWriter;

public class GenericServletDemo extends GenericServlet {

	// GenericServlet is a class that implements Servlet Interface and has given body
	// to 4 abstract methods. init,destroy,getServletConfig,getServletInfo
	// only abstract method is service()
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException , IOException {
		
		System.out.println("GenericServlet servlet created-servicing");
		
		// set contenttype
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<br>This is a servlet created using generic servlet class");
	}

}
