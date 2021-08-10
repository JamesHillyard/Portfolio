package fish.payara.james.portfolio.servlettutorial.extendeddemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Checks if the user is an admin and redirects them to the appropriate jsp page.
 */
@WebServlet("/WelcomeLogin")
public class WelcomeLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        boolean isAdmin = IsAdmin.checkAdmin(username);
        if (isAdmin) {
            HttpSession session = request.getSession();
            session.setAttribute("isAdmin", true);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/AdminHome.jsp");
            dispatcher.forward(request, response);
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/UserHome.jsp");
        dispatcher.forward(request, response);
    }


}
