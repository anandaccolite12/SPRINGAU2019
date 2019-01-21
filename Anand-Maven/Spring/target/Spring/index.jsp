<%@page import="com.pkg.JDBCTemplateDAO"%>
<html>
	<head>
	<%
		JDBCTemplateDAO objec= new JDBCTemplateDAO();//Creating class Object
		int sum=objec.add(10,12);//Calling add Method
	%>
	</head>
	
	<body>
		<h1>Taxi Drivers Details</h1>
		<h4>Addition of two number is <%=sum%> </h4>
	</body>
</html>