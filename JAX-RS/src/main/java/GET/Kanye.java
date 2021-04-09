package GET;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/kanye")
public class Kanye {
    Client client = ClientBuilder.newClient();

    @GET
    @Produces("text/plain")
    public Response getQuote(){
        WebTarget webTarget = client.target("https://api.kanye.rest/?format=text");
        Response response = webTarget.request().get();
        return response;
    }
}
