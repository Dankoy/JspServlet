<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Expressions</title>
<meta name = "keywords" content = "JSP, expressions, servlets">
<meta name = "descriptions" content = "Simple example of JSP expressions">
</head>
<body>
	<h2>JSP Expressions</h2>
	
	<ul>
		<li>Current time: <%= new java.util.Date() %></li>
		<li>Server: <%= application.getServerInfo() %></li>
		<li>Session ID: <%= session.getId() %></li>
		<li>The <code>testParam</code> from parameter: <%= request.getParameter("testParam") %></li>
	</ul>
</body>
</html>