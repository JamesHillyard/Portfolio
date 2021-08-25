package fish.payara.james.portfolio.arquillian.cdi;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.noContent;
@Path("/largeIncrement")
public class EndpointLargeIncrement {

    @Inject
    CdiBean bean;

    @GET
    public Response largeIncrement(){
        bean.setCounter(100);
        return noContent().status(200).build();
    }
}
