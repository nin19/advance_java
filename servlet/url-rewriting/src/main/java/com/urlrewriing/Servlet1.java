package com.urlrewriing;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet1 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException , ServletException {
		try(PrintWriter out = res.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<body>");
			
			String name = req.getParameter("user_name");
			
			out.println("<h1> Your name is "+name+" </h1>");
			out.println("<a href='servlet2?user="+name+"'>Enter to Goto servlet2</a>");
			
			out.println("</body>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
