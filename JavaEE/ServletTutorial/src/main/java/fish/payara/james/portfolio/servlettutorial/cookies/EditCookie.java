package fish.payara.james.portfolio.servlettutorial.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creates a cookie with the same name as an existing cookie, overwriting it
 */
@WebServlet("/EditCookie")
public class EditCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie basket = new Cookie("Basket", "Milk, Sugar, Coffee");
		basket.setMaxAge(60);
		response.addCookie(basket);
		response.sendRedirect("/CookieInfo");
	}
}
