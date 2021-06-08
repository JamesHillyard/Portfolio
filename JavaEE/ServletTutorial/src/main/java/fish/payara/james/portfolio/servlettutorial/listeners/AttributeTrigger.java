package fish.payara.james.portfolio.servlettutorial.listeners;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A servlet to trigger all aspects of the attribute listener and outputting the state in the server logs.
 */
@WebServlet("/AttributeTrigger")
public class AttributeTrigger extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();  
		context.setAttribute("Trigger", "Created");
		System.out.println("Created, Trigger Value: "+context.getAttribute("Trigger"));
		context.setAttribute("Trigger", "Edited");
		System.out.println("Edited, Trigger Value: "+context.getAttribute("Trigger"));
		context.removeAttribute("Trigger");
		System.out.println("Deleted, Trigger Value: "+context.getAttribute("Trigger"));
	}


}
