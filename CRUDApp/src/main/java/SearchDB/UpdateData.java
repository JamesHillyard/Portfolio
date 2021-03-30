package SearchDB;

import jdbc.CompanyService;
import databaseOperations.UpdateRow;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet(name = "UpdateData", value = "/UpdateData")
public class UpdateData extends HttpServlet {

    @Inject
    UpdateRow updateRow;

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("ID"));
            String companyName = request.getParameter("companyName");
            updateRow.updateRow(id, companyName);
        } catch (Exception ex) {
            request.setAttribute("ErrorMessage", ex.getMessage());
            response.getWriter().write(ex.getMessage());
        }
        javax.servlet.RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Update.jsp");
        dispatcher.forward(request, response);
    }
}
