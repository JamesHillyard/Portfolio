package fish.payara.james.portfolio.crudapp.searchdb;

import fish.payara.james.portfolio.crudapp.databaseoperations.DeleteRow;
import fish.payara.james.portfolio.crudapp.jdbc.CompanyService;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "DeleteData", value = "/DeleteData")
public class DeleteData extends HttpServlet {
    @Resource(lookup = "fish/payara/james/portfolio/crudapp/jdbc/mysqlPool")
    private DataSource dataSource;

    @Inject
    DeleteRow deleteRow;
    @Inject
    CompanyService companyService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("ID"));
            String companyName = request.getParameter("companyName");
            if(companyService.findCompany(id) != null){
                deleteRow.removeRow(id);
                request.setAttribute("Deleted", id);
            } else {
                request.setAttribute("ErrorMessage", "That ID doesn't exist in the table.");
            }
        } catch (Exception ex){
            request.setAttribute("ErrorMessage", ex.getMessage());
            response.getWriter().write(ex.getMessage());
        }
        javax.servlet.RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Delete.jsp");
        dispatcher.forward(request, response);
    }
}
