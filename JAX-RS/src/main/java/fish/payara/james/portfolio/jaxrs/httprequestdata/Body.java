package fish.payara.james.portfolio.jaxrs.httprequestdata;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/body")
public class Body {

    /**
     * The only parameter without annotation will be a container for the request body.
     */
    @POST
    public String viewMethodBody(String body) {
        return body;
    }
}
