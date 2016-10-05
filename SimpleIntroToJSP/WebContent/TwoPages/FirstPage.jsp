<%-- Use dynamic include --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First page</title>
</head>
<body>
	<h2>This page will use import directive to add random list</h2>
	
	<p>
		Here it will use <b>jsp:include page</b> directive.<br>
		That means a dynamic include will make a request (using the request dispatcher) that will<br> 
		execute the indicated page and then include the output from the page in the output of the<br> 
		calling page, in place of the <b>jsp:include</b> statement.<br><br>
	</p>
	<p>
		Additional info:<br>
		Dynamic: adds the content from the value of the page attribute to the current page at request time.<br>
		Was intended more for dynamic content coming from JSPs. <br><br>
	</p>
	<p>More information here: <a href = "http://stackoverflow.com/questions/14580120/whats-the-difference-between-including-files-with-jsp-include-directive-jsp-in">StackOverflow</a></p>
		
	<jsp:include page = "/WEB-INF/include/RandomIntList.jsp" />
	
	<jsp:include page = "/WEB-INF/include/Footer.jsp"/>
</body>
</html>