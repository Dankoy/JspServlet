<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing isThreadSafe="false"</title>
</head>
	<%@ page isThreadSafe="false" %>
	<% try { 
		Thread.sleep(20000); 
   		} catch(InterruptedException ie) {} %>
	<%! private int instanceHitCount = 0; %>
	<% instanceHitCount++; %>
	<%! private static int classHitCount = 0; %>
	<% classHitCount++; %>
<body>
	<H2>Testing isThreadSafe="false"</H2>
	<UL>
  		<LI>Instance hit count: <%= instanceHitCount %>
  		<LI>Class hit count: <%= classHitCount %>
	</UL>
	<HR> Submit the URL of this page simultaneously in two different browsers. There are three possible results:
	<UL>
  		<LI>The first page appears in about 20 seconds; 
      		the second page appears in about 40 seconds.
      		This result means that the system is queueing 
      		the requests and handling them one at a time.
      		(Aside: note that "queueing" is the word with the most
     		 consecutive vowels in the English language.)
  		<LI>The first page appears in about 20 seconds; 
      		the second page appears in about 20 seconds also.
      		The first page lists instance and class hit counts
      		of 1, the second page lists a class hit count of 2
      		but an instance hit count of 1. And, as you repeatedly
      		submit the two pages at once, the class hit count gets
      		further and further ahead of the instance hit count.
      		This result means that the system is making multiple
      		instances of the servlet. 
  		<LI>The first page appears in about 20 seconds; 
      		the second page appears in about 20 seconds also.
      		The first page lists instance and class hit counts
      		of 1, the second page lists instance and class hit counts
      		of 2. And, as you repeatedly
      		submit the two pages at once, the class hit count stays
      		the same as the instance hit count.
      		This result means that the system is ignoring 
      		isThreadSafe="false". 
	</UL>

</body>
</html>