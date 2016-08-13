

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" })
public class SimpleServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET Method!");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("user");
		HttpSession session = request.getSession();
		
		ServletContext context = request.getServletContext();
		
		if (user != "" && user != null) {
			session.setAttribute("savedUser", user);	// Save parameter only for particular client
			session.setMaxInactiveInterval(10);
			context.setAttribute("savedUser", user); 	// Save parameter across the application. Not only one browser
		}
		out.println("<h3>Hello in html " + user + "</h3>");
		out.println("Saved attribute in session: " + (String)session.getAttribute("savedUser") + "<br>");
		out.println("Saved attribute in context: " + (String)context.getAttribute("savedUser"));

	}

}
