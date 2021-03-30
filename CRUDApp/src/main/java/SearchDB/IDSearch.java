package SearchDB;

import jdbc.Company;
import jdbc.CompanyService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "IDSearch", value = "/IDSearch")
public class IDSearch extends HttpServlet {
    @Inject
    private CompanyService companyService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int searchID = Integer.parseInt(request.getParameter("searchID"));
            Company company = companyService.findCompany(searchID);
            request.setAttribute("idRetrieved", company.getId());
            request.setAttribute("nameRetrieved", company.getName());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            request.setAttribute("ErrorMessage", "SQLException Error");
        } catch (NullPointerException npe){
            request.setAttribute("ErrorMessage", "That ID doesn't exist");
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Search.jsp");
        dispatcher.forward(request, response);
    }

}
