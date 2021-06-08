package fish.payara.james.portfolio.crudapp.searchdb;

import fish.payara.james.portfolio.crudapp.databaseoperations.InsertRow;
import fish.payara.james.portfolio.crudapp.crudapputils.ValidateInput;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "AddData", value = "/AddData")
public class AddData extends HttpServlet {
    @Resource(lookup = "fish/payara/james/portfolio/crudapp/jdbc/mysqlPool")
    private DataSource dataSource;

    @Inject
    InsertRow insertRow;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("ID"));
            String companyName = request.getParameter("companyName");
            ValidateInput.assertNotNull(id,companyName);
            insertRow.addRow(id, companyName);
            request.setAttribute("idAdded", id);
            request.setAttribute("nameAdded", companyName);
        } catch (Exception ex){
            request.setAttribute("ErrorMessage", ex.getMessage());
            response.getWriter().write(ex.getMessage());
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Create.jsp");
        dispatcher.forward(request, response);
    }

}
