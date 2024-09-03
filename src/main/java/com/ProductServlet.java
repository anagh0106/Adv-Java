package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String ProductName=req.getParameter("pname");
		String Price=req.getParameter("price");
		String Quantity=req.getParameter("qty");
		String Category=req.getParameter("catg");
		
		String dburl="jdbc:mysql://localhost:3306/royal";
		String user="root";
		String pass="root";
		String calssurl="com.mysql.cj.jdbc.Driver";
	
		boolean isError=false;
		
		req.setAttribute("PnameInput", ProductName);
		req.setAttribute("PriceInput", Price);
		req.setAttribute("QtyInput", Quantity);
		req.setAttribute("CategoryInput", Category);
		// 1. Validation Portion
		
		// ProductName
		if(ProductName==null || ProductName.trim().length()==0) {
			isError=true;
			req.setAttribute("ProductNameError", "Enter ProductName");
		}
		else {
			String ProductRegEx="[A-Za-z0-9`\\s`]{2,30}";
			
			if(ProductName.matches(ProductRegEx)==false) {
				isError=true;
				req.setAttribute("ProductNameError", "Enter Valid ProductName");
			}
		
		}
		// Category
		if(Category==null || Category.trim().length()==0) {
			isError=true;
			req.setAttribute("CategoryError", "Enter Product Category ");
		}
		else {
			String CategoryRegEx="[A-Za-z`\\s`]{2,30}";
			
			if(Category.matches(CategoryRegEx)==false) {
				isError=true;
				req.setAttribute("CategoryError", "Enter Valid Product Category");
			}
		
		}
		// Price
		Integer Pprice=null;
		if(Price==null || Price.trim().length()==0) {
			isError=true;
			req.setAttribute("PriceError", "Enter Product Price");
		}
		else {
			try {
				Pprice=Integer.parseInt(Price);
			}catch(NumberFormatException e) {
				isError=true;
				req.setAttribute("PriceError", e);
			}
		}
		// Quantity
		Integer Qty=null;
		if(Quantity==null || Quantity.trim().length()==0) {
			isError=true;
			req.setAttribute("QuantityError", "Enter Product Quantity");
		}
		else {
			try {
				Qty=Integer.parseInt(Quantity);
			}catch(NumberFormatException e) {
				isError=true;
				req.setAttribute("QuantityError", e);
			}
		}
		
		
		if(isError==true) {
			RequestDispatcher rd=req.getRequestDispatcher("Products.jsp");
			rd.forward(req, res);
		}
		else {
		try {
		
			// 2. DB Connection
			Class.forName(calssurl);
		
			Connection c=DriverManager.getConnection(dburl,user,pass);
			
			String q="insert into MyProducts(ProductName,Category,Quantity,Price) values(?,?,?,?)";
			PreparedStatement ps=c.prepareStatement(q);
			
			ps.setString(1, ProductName);
			ps.setString(2, Category);
			ps.setInt(3, Qty);
			ps.setInt(4, Pprice);
			ps.executeUpdate();
			RequestDispatcher rd=req.getRequestDispatcher("ProductServletSuccess");
			rd.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("DBError", "Some Error With Database Or DBQuery");
			req.getRequestDispatcher("Products.jsp").forward(req, res);;
		}
	}
}
}