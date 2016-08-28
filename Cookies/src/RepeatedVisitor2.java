

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Servlet do the same as previous one but use CookieUtilities class", urlPatterns = { "/RepeatedVisitor2" })
public class RepeatedVisitor2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean noob = true;
		String title = "";
		String docType = "<!DOCTYPE html>\n";
		PrintWriter out = response.getWriter();
		
		String value = CookieUtilities.getCookieValue(request, "repeatedVisitor2", "no");
		
		if(value.equals("yes")) {
			noob = false;
		}
		
		if(noob) {
			Cookie returnVisitorCookie = new Cookie("repeatedVisitor2", "yes");
			returnVisitorCookie.setMaxAge(10);
			response.addCookie(returnVisitorCookie);
			title = "Greetings Stranger, You've met with a terrible fate, haven't you?";
		}
		else {
			title = "Welcome Back!";
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
