

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReloadingServlet
 */
@WebServlet(description = "Servlet will reload every 5 seconds. Using header - Refresh")
public class ReloadingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setIntHeader("Refresh", 5);
		
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 5.0 " + "Transitional//EN\">\n";
		String title = "Refreshing servlet";
		
		out.println(docType + 
					"<html>\n" + 
					"<head><title>" + title + "</title></head>\n" +
					"<body>\n" +
					"<h2 align = \"center\">" + title + "</h2>\n" + 
					"<p>The time is: " + new Date() + "</p>\n" +
					"</body></html>");
	}

}
