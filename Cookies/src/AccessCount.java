

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Servlet that prints per-client access counts")
public class AccessCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String title = "Access count Servlet";
		String docType = "<!DOCTYPE html>\n";
		PrintWriter out = response.getWriter();
		
		String countString = CookieUtilities.getCookieValue(request, "accessCount", "1");
		
		int count = 1;
		
		try {
			count = Integer.parseInt(countString);
		} catch(NumberFormatException nfe) {}
		
		Cookie cookie = new Cookie("accessCount", String.valueOf(count + 1));
		response.addCookie(cookie);
		
		out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<center>\n" +
                "<h1>" + title + "</h1>\n" +
                "<h2>This is visit number " + count + " by this browser.</h2>\n" +
                "</center></body></html>");
		
		out.close();
	}

}
