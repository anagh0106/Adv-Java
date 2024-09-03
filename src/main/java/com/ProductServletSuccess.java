package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductServletSuccess")
public class ProductServletSuccess extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String dburl="jdbc:mysql://localhost:3306/royal";
		String user="root";
		String pass="root";
		String Classurl="com.mysql.cj.jdbc.Driver";
		try {
		
			Class.forName(Classurl);
			
			Connection c=DriverManager.getConnection(dburl,user,pass);
			PreparedStatement ps=c.prepareStatement("select * from MyProducts");
			ResultSet rs=ps.executeQuery();		
			req.setAttribute("rs", rs);
			req.getRequestDispatcher("ProductSuccess.jsp").forward(req, res);;
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	}
}