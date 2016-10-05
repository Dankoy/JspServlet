<%-- The JSP page will use @include directive to include footer file in translation phase --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Footer include</title>
</head>
<body>
	<h2 align = "center">Some random header</h2>
	<p>Welcome to random page</p>
	<p>Lower you will see included footer from other jsp</p>
	<%@include file="/WEB-INF/include/Footer.jsp" %>
</body>
</html>