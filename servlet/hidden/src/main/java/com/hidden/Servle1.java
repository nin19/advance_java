package com.hidden;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servle1 extends HttpServlet {
	

	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException , ServletException {
		try(PrintWriter out = res.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<body>");
			
			String name = req.getParameter("name");
			
			out.println("<h1> Your name is "+name+" </h1>");
			
			// hidden form 
			out.println("<form action='servlet2'>");
			out.println("<input type='hidden' name='hidden_user' value='"+name+"' />");
			out.println("<button type='submit'>Jump to Servlet2</button>");
			out.println("</form>");
			
			out.println("</body>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
