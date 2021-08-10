package fish.payara.james.portfolio.servlettutorial.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fish.payara.james.portfolio.servlettutorial.servletutil.GetCookie;

/**
 * Shows all information about the cookie "basket"
 */
@WebServlet("/CookieInfo")
public class CookieInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Cookie currentCookie = GetCookie.getCookie(request, "Basket");
		PrintWriter writer = response.getWriter();
		writer.println("Name: "+currentCookie.getName());
		writer.println("Data: "+currentCookie.getValue());
		} catch (Exception ex) {
			request.setAttribute("ErrorCode", ex);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ErrorHandlerGeneral");
			dispatcher.forward(request, response);
		}
	}


}
