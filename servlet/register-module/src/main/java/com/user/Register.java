package com.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import java.io.PrintWriter;
import java.sql.DriverManager;
import java.io.IOException;
//import java.sql.DriverManager;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.*;

@MultipartConfig
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws ServletException , IOException{
		res.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = res.getWriter()){

			// Fetching data from request
			String name = req.getParameter("user_name");
			String pass = req.getParameter("user_password");
			String email = req.getParameter("user_email");
			//Part part = req.getPart("image");
			
			if(name==null || pass==null || email==null) {
				out.println("<h1>Mandatory Fields not entered </h1>");
				return;
			}
//			out.println("<h1>"+name+" "+pass+" "+email+" </h1>");
			
			//JDBC Connection
			try {
				Thread.sleep(2000);
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","Niraj@123");
				
				
				String query = "INSERT INTO user(user_name,user_pass,user_email) VALUES(?,?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1,name);
				ps.setString(2,pass);
				ps.setString(3,email);
				
				int ret = ps.executeUpdate();
				if(ret == 0) {
					out.println("Couldnt insert data");
					return;
				}
				out.println("done");
				
				
			}catch(ClassNotFoundException e) {
				System.out.println("JDBC class didnt load");
				out.println("error..");
				return;
			}catch(SQLException se) {
				se.printStackTrace();
				out.println("error..");
				return;
			} catch (InterruptedException e) {
				e.printStackTrace();
				out.println("error..");
				return;
			}

		}
	}
}
