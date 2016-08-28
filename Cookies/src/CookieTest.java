

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest
 */
@WebServlet(description = "Testing Cookie")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		for (int i = 0; i < 2; i++) {
			// Default maxAge is -1, indicating cookie applies only for current session 
			Cookie cookie = new Cookie("Session-Cookie", "Cookie-Value-S" + i);
			response.addCookie(cookie);
			
			// Cookie is valid for one hour, even if user close browser or reboots computer
			cookie = new Cookie("Persistent-Cookie-" + i, "Cookie-Value-P" + i);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE html>\n";
		String title = "Active Cookies";
		
		out.println(docType + 
					"<html>\n" +
					"<head><title>" + title + "</title></head>\n" +
					"<body>\n" +
					"<h1 align = \"center\">" + title + "</h1>\n" +
					"<table border=1 align=\"center\">\n" +
					"<th>Cookie Name\n" +
					"<th>Cookie Value");
		
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			out.println("<tr><th>No Cookies");
		}
		else {
			for(Cookie cookie: cookies) {
				out.println("<tr>\n" +
							"<td>" + cookie.getName() + "\n" +
							"<td>" + cookie.getValue());
			}
		}
		out.println("</table></body></html>");
		
	}

}
