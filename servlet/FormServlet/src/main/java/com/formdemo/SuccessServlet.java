package com.formdemo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SuccessServlet extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException , IOException{
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		out.println("<h1>This is a Success Servlet</h1>");
		out.println("<h1>Msg sent by Form Servlet :</h1>");
		
		String msg = (String)req.getAttribute("msg");
		out.println("<h1>"+msg+"</h1>");
	}
}
