package com.urlrewriing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	
       
    
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException , ServletException {
		try(PrintWriter out = res.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<body>");
			
			out.println("<h1>Welcome to servlet 2</h1>");
			String name = req.getParameter("user");
			out.println("<h2>Your name from servlet1 : "+name+"</h2>");
			
			out.println("</body>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
