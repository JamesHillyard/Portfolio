package fish.payara.james.portfolio.servlettutorial.cookies;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create as a new cookie named "Basket" with the value "Bread"
 */
@WebServlet("/CreateCookie")
public class CookieSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie basket = new Cookie("Basket", "Bread");
		basket.setMaxAge(1800);
		response.addCookie(basket);
		response.sendRedirect("/CookieInfo");
	}
}
