package demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sets the error message attribute and directs back to the starting input page
 */
@WebServlet(
	urlPatterns = "/ErrorMessage",
	name = "SimpleDemoError"
)

public class ErrorMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("errorMessage", "Please enter a valid name.");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DemoInput.jsp");
		dispatcher.forward(request, response);
	}

}
