package fish.payara.james.portfolio.jaxrs.customexceptions;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("Error")
public class GenerateError {

    @GET
    public Response throwError() throws Exception {
        throw new Exception("JAX-RS Tutorial");
    }
}
