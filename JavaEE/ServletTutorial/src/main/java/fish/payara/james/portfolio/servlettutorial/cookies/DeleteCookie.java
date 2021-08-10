package fish.payara.james.portfolio.servlettutorial.cookies;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Deletes the "Basket" cookie by setting its max age to 0
 */
@WebServlet("/DeleteCookie")
public class DeleteCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie deleteBasketCookie = new Cookie("Basket", "");
		deleteBasketCookie.setMaxAge(0);
		response.addCookie(deleteBasketCookie);
		response.sendRedirect("/CookieInfo");
	}
}
