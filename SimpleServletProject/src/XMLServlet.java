import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class XMLServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		out.println("<h2>Hello from doGet() method, " + userName + "!</h2>");
		out.println("<h3>We know your full name: " + fullName + "</h3>");
		
		String prof = request.getParameter("prof");
		out.println("<p>You are a " + prof + "</p>");
		
	//	String location = request.getParameter("location");
		String[] location = request.getParameterValues("location");
		out.println("<p>You are at " + location.length + "places</p>");
		
		for(int i = 0; i < location.length; i++) {
			out.println(location[i]);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		out.println("<h2>Hello from doPost() method, " + userName + "!</h2>");
		out.println("<h3>We know your full name: " + fullName + "</h3>");
		
		String prof = request.getParameter("prof");
		out.println("You are a " + prof);
		
		String[] location = request.getParameterValues("location");
		out.println("<p>You are at " + location.length + "places</p>");
		
		for(int i = 0; i < location.length; i++) {
			out.println(location[i]);
		}
		
	}
	
}
