package fish.payara.james.portfolio.servlettutorial.servletutil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * A utility method to get a specific cookie by name
 */
public class GetCookie {

	public static Cookie getCookie(HttpServletRequest request, String name) {
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {
	            if (cookie.getName().equals(name)) {
	                return cookie;
	            }
	        }
	    }
	    return null;
	}
}
