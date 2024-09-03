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
	
	String PnameInput=(String) request.getAttribute("PnameInput");
	String PriceInput=(String)request.getAttribute("PriceInput");
	String QtyInput=(String)request.getAttribute("QtyInput");
	String CategoryInput=(String)request.getAttribute("CategoryInput");
	
	String ProductNameError=(String)request.getAttribute("ProductNameError");
	String CategoryError=(String)request.getAttribute("CategoryError");
	String PriceError=(String)request.getAttribute("PriceError");
	String QuantityError=(String)request.getAttribute("QuantityError");
	%>
	<form action="ProductServlet" method="post" autocomplete="off">
	
	ProductName : <input type="text" name="pname" value="<%=PnameInput==null?"":PnameInput %>">&nbsp;&nbsp;
	<%=ProductNameError==null?"":ProductNameError %>
	<br><br>
	Category : <input type="text" name="catg" value="<%=CategoryInput==null?"":CategoryInput %>">&nbsp;&nbsp;
	<%=CategoryError==null?"":CategoryError%>
	<br><br>
	Price : <input type="text" name="price" value="<%=PriceInput==null?"":PriceInput %>">&nbsp;&nbsp;
		<%=PriceError==null?"":PriceError%>
	<br><br>
	Quantity : <input type="text" name="qty" value="<%=QtyInput==null?"":QtyInput %>">&nbsp;&nbsp;
	<%=QuantityError==null?"":QuantityError %>
	<br><br>
	
	<input type="submit" value="Send">
	
	</form>
</body>
</html>