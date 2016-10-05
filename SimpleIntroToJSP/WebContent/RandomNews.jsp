<%-- This page will randomly include different pages as good news or bad news --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Randomly include different pages</title>
</head>
<body>
	<%
		String newsPage;
		if(Math.random() > 0.5) {
			newsPage = "/WEB-INF/include/GoodNews.jsp";
		}
		else {
			newsPage = "/WEB-INF/include/BadNews.jsp";
		}
	%>
	<jsp:include page = "<%= newsPage %>"  />
</body>
</html>