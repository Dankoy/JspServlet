

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that says "Welcome aboard" to first-time
 *  visitors and "Welcome back" to repeat visitors.
 */

@WebServlet(description = "Will count user accessing for the page")
public class RepeatedVisitor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean noob = true;
		String title = "";
		String docType = "<!DOCTYPE html>\n";
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cook: cookies) {
				if(cook.getName().equals("repeatVisitor") && (cook.getValue().equals("yes"))) {
					noob = false;
					break;
				}
			}
		}
		
		if(noob) {
			Cookie returnVisitorCookie = new Cookie("repeatedVisitor", "yes");
			returnVisitorCookie.setMaxAge(10);
			response.addCookie(returnVisitorCookie);
			title = "Greetings Stranger, You've met with a terrible fate, haven't you?";
		}
		else {
			title = "Welcome back!";
		}
		
		response.setContentType("text/html");
		out.println(docType +
				"<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "</body></html>");
		
	}

}
