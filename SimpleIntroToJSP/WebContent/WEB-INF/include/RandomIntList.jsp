<%-- 
	Here is the random int list. 
	First page will call this JSP using "<jsp:include page" directive.
		That means a dynamic include will make a request (using the request dispatcher) that will 
		execute the indicated page and then include the output from the page in the output of the 
		calling page, in place of the <jsp:include statement.
	Second page will call this JSP using "<%@include file" directive.
		That means a static include is exactly the same thing as copy-pasting the exact content
		of the included file (the "code") at the location of the <%@ include statement (which is
		exactly what the JSP compiler will do.
 --%>
	<%@ page import="java.lang.Math" %>
	<ul>
		<li>Random number 1 = <%= Math.random()*100 %></li>
		<li>Random number 2 = <%= Math.random()*100 %></li>
		<li>Random number 2 = <%= Math.random()*100 %></li>
	</ul>