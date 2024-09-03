package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String category = req.getParameter("catg");
		String dburl="jdbc:mysql://localhost:3306/royal";
		String user="root";
		String pass="root";
		String Classurl="com.mysql.cj.jdbc.Driver";
		try {
		
			Class.forName(Classurl);
			
			Connection c=DriverManager.getConnection(dburl,user,pass);
			PreparedStatement ps=c.prepareStatement("select * from MyProducts where Category = ?");
			ps.setString(1, category);
			ResultSet rs=ps.executeQuery();		
			req.setAttribute("rs", rs);
			req.getRequestDispatcher("OutputProductSearch.jsp").forward(req, res);;
			
	} catch (Exception e) {
			e.printStackTrace();
		}
	}
}