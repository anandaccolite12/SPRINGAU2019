<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Page</title>
</head>
<body>
		<h1>About Page</h1>
		<br><br>
		<h2>Username : </h2>		
		<%
			out.println(request.getParameter("username"));
		%>
		<br><br>
		<h2>Count : </h2>
		<%
			out.println(session.getAttribute("count"));
		%>

</body>
</html>