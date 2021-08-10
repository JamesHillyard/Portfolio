package fish.payara.james.portfolio.servlettutorial.extendeddemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Takes the username and password entered, checks if they're valid with the validateUser class & method,
 * creates a cookie and sends to an appropriate location
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean valid = ValidateUser.validateUser(username, password);
        if (valid) {
            Cookie lastUser = new Cookie("LastUser", username + ":" + password);
            lastUser.setMaxAge(1000);
            response.addCookie(lastUser);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WelcomeLogin");
            dispatcher.forward(request, response);
        }
        request.setAttribute("InfoMessage", "Invalid login.");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ExtendedDemo");
        dispatcher.forward(request, response);
    }
}
