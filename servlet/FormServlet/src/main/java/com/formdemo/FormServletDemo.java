package com.formdemo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FormServletDemo extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		// Getting the output (response) ready
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_password");
		String email = req.getParameter("user_email");
		String gender = req.getParameter("user_gender");
		String course = req.getParameter("user_course");
		
		UserData user = new UserData(name,pass,email,gender,course);
		
		String condition = req.getParameter("condition");
		if(condition!=null) {
			out.println("<h1>Welcome to Register Servlet</h1>");
			out.println(user.getData());
			
			// Calling the servlet from this servlet using Request Dispatcher
			String msg = "Successfully registered";
			req.setAttribute("msg",msg);
			RequestDispatcher rd = req.getRequestDispatcher("success");
			rd.forward(req, res);
		}else {
			out.println("<h1>You didnt accept terms and condition</h1>");
			// Using request dispatcher to include index.html files output inthe servlet output
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}
		
	}
}

class UserData {
	String name;
	String pass;
	String email;
	String gender;
	String course;
	UserData(String name,String pass,String email,String gender,String course) {
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.gender = gender;
		this.course = course;
	}
	
	String getData() {
		return "<p>Entered Name : "+name+" | Entered email :"+ email +" | Opted Course : "+course+"</p>";
	}
}
