<%@page import="java.util.*"%>
<%@page import="com.pkg.*"%>

<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>

<html>
	<head>
	<%
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		JDBCTemplateDAO objec= applicationContext.getBean(JDBCTemplateDAO.class);//Creating class Object
		ArrayList<Driver> list=objec.display();//Calling add Method
	%>
	</head>
	
	<body>
		<h1 align="center">Taxi Drivers Details</h1>
		<% for (int i=0;i<list.size();i++){%>	
		<div align="center">
		<h4>Driver Name : </h4>	
 		<% out.println(list.get(i).getDriverName());%>
		<h4>Driver ID : </h4>	
 		<% out.println(list.get(i).getDriverId());%>
		<h4>Driver Phone No : </h4>	
 		<% out.println(list.get(i).getPhoneNo());%>
		<h4>Driver Vehicle No : </h4>	
 		<% out.println(list.get(i).getVehicleRegNo());%>
		</div>
		<%}%>
	</body>
</html>