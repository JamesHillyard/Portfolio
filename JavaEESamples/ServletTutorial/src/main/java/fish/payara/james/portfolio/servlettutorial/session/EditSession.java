package fish.payara.james.portfolio.servlettutorial.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Edits the current session, overwriting some of the attributes
 */
@WebServlet("/EditSession")
public class EditSession extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("adminPassword", "TempPassword");
		session.setAttribute("Edited", "Yes");
		
    	response.sendRedirect("SessionValues.jsp");
	}
}
