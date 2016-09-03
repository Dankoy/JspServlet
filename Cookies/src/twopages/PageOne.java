package twopages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* First page user should access to recieve cookie. After it he can access second page.
 * If user doesn't have cookies from first page then if he tries to access second page,
 * he will be redirected to first page
 */


public class PageOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String title = "First page";
		String docType = "<!DOCTYPE html>\n";
		
		Cookie firstPageCookie = new Cookie("VisitedFirstPage", "yes");
		firstPageCookie.setMaxAge(10);
		response.addCookie(firstPageCookie);
		
		out.println(docType +  
					"<html>\n" +
					"<head><title>" + title + "</title></head>\n" +
					"<body>\n" + 
					"<h2 align = \"center\">" + title + "</h2>\n" +
					"<p>Click <a href = \"page-two\">here</a> to visit page two.</p>\n" + 
					"</body></html>");
		out.close();
	}

}
