

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplesAndOranges
 */
@WebServlet(description = "Servlet will create exel file and compare apples and oranges")
public class ApplesAndOranges extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/vnd.ms-excel; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("\tQ1\tQ2\tQ3\tQ4\tTotal");
	      out.println("Apples\t78\t87\t92\t29\t=сумм(B2:E2)");
	      out.println("Oranges\t77\t86\t93\t30\t=сумм(B3:E3)");
		
	}

}
