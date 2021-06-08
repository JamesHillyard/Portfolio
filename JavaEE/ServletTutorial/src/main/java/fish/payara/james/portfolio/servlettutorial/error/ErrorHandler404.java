package fish.payara.james.portfolio.servlettutorial.error;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Catches any 404 errors (as declared in the web.xml) and comes to this servlet where the user is redirected to a HTML page
 */
public class ErrorHandler404 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/404ErrorPage.html");
	}

}
