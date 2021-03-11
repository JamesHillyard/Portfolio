package error;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Catches any errors, except 404, and comes to this servlet where the user is redirected to a JSP page
 */
public class ErrorHandlerGeneral extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode != null){
            request.setAttribute("ErrorCode", statusCode);
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/GeneralErrorPage.jsp");
        dispatcher.forward(request, response);
    }
}
