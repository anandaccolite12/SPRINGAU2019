<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Login </title>
</head>
<body>
	<h1 style="text-align: center;">Login Page</h1>
		<form style="text-align: center;" action="about.jsp" method="post">
			Login id : <input  style="border: 3px solid #555; width: 20%;" type="text" name="username"/><br><br><br>
			Password : <input style="border: 3px solid #555; width: 20%;" type="password" name="password"/><br><br><br>
			
			<input type="submit" value="submit"/>
		</form>
	
		<%!
			static int count = 0; 
		%>

		<%
				count=count+1;
				session.setAttribute("count", count);
		%>

</body>
</html>