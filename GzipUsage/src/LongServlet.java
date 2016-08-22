

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LongServlet
 */
@WebServlet(description = "Prints very long page")
public class LongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long startTime = System.currentTimeMillis();
		response.setContentType("text/html");
		
		String docType = "<!DOCTYPE html>\n";
		String title = null;
		
		PrintWriter out;
		
		/* Check if gzip is supported and user didn't disable for particular request
		 * If true then create gzipped PrinterWriter
		 * If false then use regular PrintWriter 
		 */
		
		if (Gzip.isGzipSupported(request) && !Gzip.isGzipDisabled(request)) {
			out = Gzip.getGzipWriter(response);
			response.setHeader("Content-Encoding", "gzip");
			title = "Using Gzip Encoding";
		}
		else {
			out = response.getWriter();
			title = "Without Gzip Encoding";
		}
		
		out.println(docType + 
					"<html>\n" + 
					"<head><title>" + title + "</title></head>\n" + 
					"<body>\n" + 
					"<h2 align = \"center\">" + title + "</h2>\n");
		String line = "Let it be random words";
		

		for (int i = 0; i < 1000; i++) {
			out.println(line);
		}
		
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		
		out.println("<p>Time spent for output: " + time + "ms</p>\n");
		
		out.println("</body></html>");
		out.close();
		
		
		

	}

}
