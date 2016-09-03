package twopages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Second servlet checks for cookies from first page and if user has appropriate cookies then
 * servlet prints out page. Otherwise servlet will redirect user to first page.
 * */

public class SecondPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isVisited = false;
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("VisitedFirstPage") && cookie.getValue().equals("yes")) {
					isVisited = true;
					break;
				}
			}
		}
		
		if (isVisited == false) {
			response.sendRedirect("page-one");
		}
		else {
			response.setContentType("text/html");
			String title = "Second Page";
			String docType = "<!DOCTYPE html>\n";
			PrintWriter out = response.getWriter();
			out.println(docType + 
						"<head><title>" + title + "</title></head>\n" +
						"<body>\n" +
						"<h2 align = \"center\">" + title + "</h2>\n" + 
						"<p>So you visited first page and can now behold this mighty second page!</p>\n" +
						"</body></html>");
		}
	}

}
