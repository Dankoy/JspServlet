package coresession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(description = "Will show session info and per-client access counts")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		synchronized(session) {
			String heading;
			Integer accessCount = (Integer)session.getAttribute("accessCount");
			
			if(accessCount == null) {
				accessCount = 0;
				heading = "Welcome, Newcomer!";
			}
			else {
				heading = "Welcome back!";
				accessCount++;
			}
							/* Integer is an immutable data structure. So, you
							 * cannot modify the old one in-place. Instead, you
							 * have to allocate a new one and redo setAttribute.
							 */
			session.setAttribute("accessCount", accessCount);
			session.setMaxInactiveInterval(10);
			
			PrintWriter out = response.getWriter();
			String title = "Showing user session information";
			String docType = "<!DOCTYPE html>\n";
			
			out.println(docType + 
						"<html>\n" +
						"<head><title>" + title + "</title></head>\n" +
						"<body>\n" +
						"<center>\n" +
						"<h1 align = \"center\">" + heading + "</h1>\n" +
						"<h2 align = \"center\">" + title + ":</h2>\n" +
						"<table border = 1>\n" +
						"<tr>\n" +
							"<th>Info Type</th>\n" +
							"<th>Value</th>\n" +
						"<tr>\n" +
							"<td>ID\n" +
							"<td>" + session.getId() + "\n" +
						"<tr>\n" +
							"<td>Creation Time\n" +
							"<td>" + new Date(session.getCreationTime()) + "\n" +
						"<tr>\n" +
							"<td>Time of Last Access\n" +
							"<td>" + new Date(session.getLastAccessedTime()) + "\n" +
						"<tr>\n" +
							"<td>Numbers of Previous Accesses\n" +
							"<td>" + session.getAttribute("accessCount") + "\n" +
						"</table>\n" +
						"</center></body></html>");
			
		}
		
	}

}
