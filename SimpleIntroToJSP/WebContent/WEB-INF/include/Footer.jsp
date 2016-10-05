<%-- That is the footer for IncludeFooter.jsp --%>
<%@ page import = "java.util.Date" %>
<%!
	private int accessCount = 0;
	private Date accessDate = new Date();
	private String accessHost = "<i>No previous access</i>";
%>
<p>This page has been accessed <%= ++accessCount %> times since server reboot.</p>
<p>It was most recently accessed from <%= accessHost %> at <%= accessDate %>.</p>
<% 
	accessHost = request.getRemoteAddr();
	accessDate = new Date();
%>