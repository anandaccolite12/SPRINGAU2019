<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.pkg.*"%>

<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger</title>
	<%
		String id = request.getParameter("passId");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");	
		JDBCTemplateDAO objec= applicationContext.getBean(JDBCTemplateDAO.class);//Creating class Object
		Passenger passenger=objec.getDetail(id);//Calling add Method
	%>
</head>
<body>
	<h1 align="center">Passenger Details</h1>
    <form align="center" action="info.jsp" method="POST">
      Passenger Id : <input type="text" id="passId" name="passId" />
      <input type="submit" value="Submit" />
    </form>
    
    <div align="center">
    	<h4>Passenger Name : </h4>	
    	<% out.println(passenger.getPassengerName());%>
    	<h4>Passenger ID : </h4>	
    	<% out.println(passenger.getPassengerId());%>
    	
    	<h4>Passenger No : </h4>	
    	<% out.println(passenger.getPhoneNo());%>
    	
    	<h4>Passenger Email : </h4>	
    	<% out.println(passenger.getEmail());%>
    	
    	<h4>Passenger Location : </h4>	
    	<% out.println(passenger.getLocation());%>
    </div> 
 
</body>
</html>