

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelayedRedirection
 */
@WebServlet(description = "Servlet that will redirect you ito another page after some time")
public class DelayedRedirection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 5.0 Transitional//EN\">\n";
		String title = null;
		String message = null;
		
		String agent = request.getHeader("User-Agent");
		
		try {
			if(agent != null && agent.contains("MSIE")) {
				title = "Delayed redirection to Microsoft";
				message = "As long as you Microsoft slave I'm gonna redirect you to microsoft welcome page.";
				response.setHeader("Refresh", "5; URL=http://www.microsoft.com");
			}
			else if(agent != null && agent.contains("Firefox")) {
				title = "Delayed redirection to Firefox";
				message = "Open-Source community is the best! Good job!";
				response.setHeader("Refresh", "5; URL=http://www.mozilla.com");
			}
			else if(agent != null && agent.contains("Chrome")) {
				title = "Delayed redirection to Google";
				message = "Evil corporation still knows where you live!";
				response.setHeader("Refresh", "5; URL=http://www.google.com");
			}
			
			out.println(docType + 
						"<html>\n" +
						"<head><title>" + title + "</title></head>\n" +
						"<body>\n" +
						"<h1 align = \"center\">" + message + "</h1>\n" +
						"<p>Wait a bit.</p>\n" +
						"</body></html>");
		}
		finally {
			out.close();
		}
		
	}

}
