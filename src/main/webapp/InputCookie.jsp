<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="InputCookieServlet" method="post">
	
	FirstName : <input type="text" name="fname"><br><br>
	<input type="submit" value="Submit">
	<br>
	<a href="ViewCookie.jsp">View Cookie</a> <br>
	<a href="LogoutCookie">Logout</a>
	
	</form>
</body>
</html>