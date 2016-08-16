

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet which allow you to look at headers from request
 */

public class ShowAllHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String title = "Servlet that show you request headers";
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 5.0 " + "Transitional//EN\">\n";
		
		out.println(docType + 
				"<html>\n" + 
				"<head><title>" + title + "</title></head>\n" + 
				"<body>\n" + 
				"<h1 align = \"center\">" + title + "</h1>\n" +
				"<div style =\"margin-left: 20%\">\n" +
				"<b>Request Method: </b>" + request.getMethod() + "<br>\n" + 
				"<b>Request URI: </b>" + request.getRequestURI() + "<br>\n" + 
				"<b>Request URL: </b>" + request.getRequestURL() + "<br>\n" + 
				"<b>Request Protocol: </b>" + request.getProtocol() + "<br>\n" +
				"</div>\n" +
				"<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
                "<TR BGCOLOR=\"#FFAD00\">\n" +
                "<TH>Header Name<TH>Header Value");
		
		Enumeration<String> headerNames = request.getHeaderNames();
			while(headerNames.hasMoreElements()) {
					String headerName = headerNames.nextElement();
					out.println("<TR><TD>" + headerName);
					out.println("    <TD>" + request.getHeader(headerName));
			}
			
			out.println("</TABLE>\n</BODY></HTML>");
		
		}
	
}
