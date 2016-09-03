package coresession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Accumulates all items in ArrayList with no attempt of detecting repeated items
 */
@WebServlet(description = "Displays a list of items being ordered")
public class ShowItems extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		synchronized(session) {
			@SuppressWarnings("unchecked")
			List<String> previousItems = (List<String>)session.getAttribute("previousItems");
			if(previousItems == null) {
				previousItems = new ArrayList<String>();
			}
			String newItem = request.getParameter("newItem");
			if((newItem != null) && (!newItem.trim().equals(""))) {
				previousItems.add(newItem);
			}
			session.setAttribute("previousItems", previousItems);
			session.setMaxInactiveInterval(10);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String title = "Items selected to purchase";
			String docType = "<DOCTYPE html>\n";
			
			out.println(docType + 
						"<html>\n" +
						"<head><title>" + title + "</title></head>" +
						"<body>\n" +
						"<h2 align = \"center\">" + title + "</h2>");
			
			if(previousItems.size() == 0) {
				out.println("<i>No Items</i>");
			}
			else {
				out.println("<ul>\n");
				for(String item: previousItems) {
					out.println("<li>" + item);
				}
				out.println("</ul>\n");
			}
			out.println("</body></html>");
		}
	}

}
