package fish.payara.james.portfolio.servlettutorial.extendeddemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A method to take the appropriate cookie, break the data down into its component parts and perform the logic done by the regular system.
 */
@WebServlet(name = "LoginCookie", value = "/LoginCookie")
public class LoginCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Cookie lastUser = fish.payara.james.portfolio.servlettutorial.servletutil.GetCookie.getCookie(request, "LastUser");
            String[] cookieData = lastUser.getValue().split(":");
            String username = cookieData[0];
            String password = cookieData[1];
            boolean valid = ValidateUser.validateUser(username, password);
            boolean isAdmin = IsAdmin.checkAdmin(username);
            if (valid) {
                if (isAdmin) {
                    HttpSession session = request.getSession();
                    session.setAttribute("isAdmin", true);
                    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/AdminHome.jsp");
                    dispatcher.forward(request, response);
                }
                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/UserHome.jsp");
                dispatcher.forward(request, response);
            }
        } catch (NullPointerException ex) {
            request.setAttribute("InfoMessage", "No cookie data.");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ExtendedDemo");
            dispatcher.forward(request, response);
        }
    }
}
