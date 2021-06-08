package fish.payara.james.portfolio.crudapp.jdbc;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("/company")
@RequestScoped
public class CompanyResource {
    @Inject
    private CompanyService companyService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Company sayHello(@PathParam("id") int id) throws SQLException {
        return companyService.findCompany(id);
    }
}
