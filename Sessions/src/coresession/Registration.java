package coresession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 
 */
@WebServlet(description = "Registration with session tracking")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String checkVal(String orig, Object sessionVal, String replacement) {
		if((orig != null) && (!orig.equals(""))) {
			return orig;
		}
		else if(sessionVal != null) {
			return (String)sessionVal;
		}
		else {
			return ("<font color = red><b>" + replacement + "</b></font>\n");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		synchronized(session) {
			String firstName = checkVal(request.getParameter("firstName"), session.getAttribute("lastName"), "Unknown first name");
			String lastName = checkVal(request.getParameter("lastName"), session.getAttribute("lastName"), "Unknown last name");
			String emailAddress = checkVal(request.getParameter("emailAddress"), session.getAttribute("lastName"), "Unknown email address");
			
			session.setAttribute("firstName", firstName);
			session.setAttribute("lastName", lastName);
			session.setAttribute("emailAddress", emailAddress);
			
			PrintWriter out = response.getWriter();
			String title = "Registration with session";
			String docType = "<DOCTYPE html>\n";
			
			out.println(docType + 
						"<html>\n" +
						"<head><title>" + title + "</title></head>" +
						"<body>\n" +
						"<h2 align = \"center\">" + title + "</h2>" +
						"<ul>\n" +
						"<li><b>First Name</b>: " + firstName + "</li>\n" +
						"<li><b>Last Name</b>: " + lastName + "</li>\n" +
						"<li><b>Email Address</b>: " + emailAddress + "</li>\n" +
						"</ul>\n" + 
						"</body></html>");
		}
		
	}

}
