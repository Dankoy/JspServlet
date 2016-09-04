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
 * Servlet does the same thing as with cookies but using sessions tracking 
 */
@WebServlet(description = "Use session to find out if user was here already")
public class RepeatedVisitor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10);
		String title;
		
		synchronized(session) {
			if(session.getAttribute("repeatedVisitor") == null) {
				title = "Welcome Aboard! You have met with horrible fate, haven't you?";
				session.setAttribute("repeatedVisitor", "yes");
			}
			else {
				title = "Welcome Back!";
			}
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			String docType = "<DOCTYPE html>\n";
			out.println(docType +
					"<html>\n" +
	                "<head><title>" + title + "</title></head>\n" +
	                "<body>\n" +
	                "<h1 align=\"center\">" + title + "</h1>\n" +
	                "</body></html>");
		}
		
	}

}
