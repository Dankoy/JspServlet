/* This servlet will check your referer header and redirect you to welcome page if your referer is not "index"
 * Otherwise you will see message that you was not redirected*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Redirection
 */
@WebServlet(description = "Redirect to index")
public class Redirection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String title = "Redirection Checker Servlet";
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 5.0 " + "Transitional//EN\">\n";
		
		String ref = request.getHeader("Referer");
		
		try {
			if (ref != null && ref.contains("HeadersProj/index.html")) {
				out.println(docType + 
						"<head><title>" + title + "</title></head>\n" +
						"<body>\n" +
						"<h1>You was not redirected to index. Good job!</h1>\n" + 
						"</body>\n" + 
						"</html>");
			}
			else {
				response.sendRedirect("http://localhost:8080/HeadersProj/index.html");
			}
		}
		finally {
			out.close();
		}
	}

}
