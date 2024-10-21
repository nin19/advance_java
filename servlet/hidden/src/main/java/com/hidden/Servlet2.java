package com.hidden;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet2 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException , ServletException {
		try(PrintWriter out = res.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<body>");
			
			String name = req.getParameter("hidden_user");
			
			out.println("<h2> Welcome to servlet2 </h2>");
			out.println("<h1> Your name is "+name+" </h1>");
			
			out.println("</body>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
