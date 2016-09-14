package corejsp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

//Two static methods for use in cookie handling.

public class CookieUtilities extends HttpServlet {
	
	 /* Given the request object, a name, and a default value,
	   *  this method tries to find the value of the cookie with
	   *  the given name. If no cookie matches the name,
	   *  the default value is returned.
	   */
	public static String getCookieValue(HttpServletRequest request, String cookieName, String defaultValue) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for(Cookie cook: cookies) {
				if (cookieName.equals(cook.getName())) {
					return(cook.getValue());
				}
			}
		}
		return(defaultValue);
	}
	
	/* Given the request object and a name, this method tries
	  *  to find and return the cookie that has the given name.
	  *  If no cookie matches the name, null is returned.
   */
	
	public static Cookie getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cook: cookies) {
				if(cookieName.equals(cook.getName())) {
					return(cook);
				}
			}
		}
		return(null);
	}
}

