<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		ResultSet rs=(ResultSet)request.getAttribute("rs");
		
	%>
	<h1>Product Information</h1>
	<table border="1">
	
	<tr >
	
		<th>Product_Id</th>
		<th>ProductName</th>
		<th>Category</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Total</th>
	
	</tr>
	
		<%
			if(rs!=null){
				while(rs.next()){
					Integer Product_Id=rs.getInt("Product_Id");
					String ProductName=rs.getString("ProductName");
					String Category = rs.getString("Category");
					Integer Price=rs.getInt("Price");
					Integer Quantity=rs.getInt("Quantity");
					Integer Total=rs.getInt("Total");
					
				
				    out.println("<tr>");
		            out.print("<td>" + Product_Id+ "</td>");
		            out.print("<td>" + ProductName + "</td>");
		            out.print("<td>" + Category + "</td>");
		            out.print("<td>" + Price + "</td>");
		            out.print("<td>" + Quantity + "</td>");
		            out.print("<td>" + Total + "</td>");
		           
		            out.print("</tr>");
				}
			}
			else{
				 out.println("<center><tr><td colspan='4'>No data available</td></tr></center>");
			}
		%>
	
	
	</table>


</body>
</html>