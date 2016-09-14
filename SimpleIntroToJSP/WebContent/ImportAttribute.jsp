<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The import Attribute</title>
</head>
<body>
	<h2>The import Attribute</h2>
	<%@page import = "java.util.*, corejsp.*" %>
	
	<%-- JSP Declaration --%>
	<%! 
		private String randomID() {
			int num = (int)(Math.random()*1000000);
			return ("id" + num);
		}
		private final String NO_VALUE = "<i>No Value</i>";
	%>
	
	<%-- JSP Scriptlet --%>
	<%
		String oldID = CookieUtilities.getCookieValue(request, "userID", NO_VALUE);
		if (oldID.equals(NO_VALUE)) {
			String newID = randomID();
			Cookie cookie = new OneMinuteCookie("userID", newID);
			response.addCookie(cookie);
		}
	%>
	
	<%-- JSP Expression --%>
	<p>This page was accessed on <%= new Date() %> with a userID cookie of <%= oldID %></p>
	
	
</body>
</html>