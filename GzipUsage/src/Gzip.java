import java.io.*;

import javax.servlet.http.*;

import java.util.zip.*;

/* This class contains method which check if gzip encoding is supported in browser or not.
 * And method that will check if user passed in a flag saying that gzip encoding should be
 * disabled for this request.
 * In case if browser use gzip encoding and user allowed its usage then
 * return gzipping PrinterWriter for response. */

public class Gzip {

	public static boolean isGzipSupported(HttpServletRequest request) {			// Check if gzip is supported in particular browser
		String encoding = request.getHeader("Accept-Encoding");
		if(encoding != null && encoding.contains("gzip")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isGzipDisabled(HttpServletRequest request) {		// Check if user passed in flag saying that gzip encoding should be																
		String flag = request.getParameter("disableGzip");					// gzip encoding should be disabled for this request 	
		if (flag != null && !flag.equalsIgnoreCase("false")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static PrintWriter getGzipWriter(HttpServletResponse response) throws IOException {	// Return Gzipping PrintWriter
		return (new PrintWriter (new GZIPOutputStream (response.getOutputStream())));
	}
	
}
