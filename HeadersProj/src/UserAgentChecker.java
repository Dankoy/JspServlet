

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserAgentChecker
 */
@WebServlet(description = "Check User-Agent header for request and show info for different browsers")
public class UserAgentChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String title = null, message = null;
		
		String agent = request.getHeader("User-Agent");
		
		if (agent != null && agent.contains("MSIE") ) {
			title = "Microsoft minion";
			message = "Hello for Microsoft user lol";
		}
		else if(agent != null && agent.contains("Firefox")) {
			title = "Firefox slave";
			message = "Hello for burning fox user";
		}
		else if(agent != null && agent.contains("Chrome")) {
			title = "Google guy";
			message = "Google knows where you live";
		}
		
		String docType =
			      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
			      "Transitional//EN\">\n";
		out.println(docType +
			        		"<HTML>\n" +
			                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
			                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
			                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
			                message + "\n" +
			                "</BODY></HTML>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
