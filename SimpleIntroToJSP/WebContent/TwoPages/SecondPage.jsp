<%-- Use static include --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Second page</title>
</head>
<body>
	<h2>This page will use import directive to add random list</h2>
	
	<p>
		Here it will use <b>jsp%@ include file</b> directive.<br>
		That means a static include is exactly the same thing as copy-pasting the exact content <br>
		of the included file (the "code") at the location of the <b>%@ include</b> statement (which is <br>
		exactly what the JSP compiler will do. <br><br>
	<p>
	<p>
		Additional info:<br>
		Static: adds the content from the value of the file attribute to the current page at translation time.<br> 
		The directive was originally intended for static layout templates, like HTML headers.<br><br>
	</p>
	<p>More information here: <a href = "http://stackoverflow.com/questions/14580120/whats-the-difference-between-including-files-with-jsp-include-directive-jsp-in">StackOverflow</a></p>
	
	<%@ include file = "/WEB-INF/include/RandomIntList.jsp" %>
	
	<%@ include file = "/WEB-INF/include/Footer.jsp" %>
</body>
</html>