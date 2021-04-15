package CDIImplementation;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/employee/{id}")
@RequestScoped
public class Employee {
    String id;

    public Employee(){

    }

    @Inject
    public Employee(@PathParam("id") String id) {
        this.id = id;
    }

    @GET
    public String getEmployee(){
        return "Employee [id="+id+"]";
    }
}
