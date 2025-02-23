package com.servlet.test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HttpServletDemo extends HttpServlet{
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException{
		
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		System.out.println("HTTPSERVLET doGet method invoked");
		out.println("<h1>This is a HttpServlet using get method</h1>");
	}
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException{
		
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		System.out.println("HTTPSERVLET doPost method invoked");
		out.println("<h1>This is a HttpServlet using post method</h1>");
	}
}

/*
     private static final String METHOD_DELETE = "DELETE";
    private static final String METHOD_HEAD = "HEAD";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_OPTIONS = "OPTIONS";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final String METHOD_TRACE = "TRACE";			// Http methods defined in sourcecode
 */