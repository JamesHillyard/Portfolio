package fish.payara.james.portfolio.arquillian.cdi;

import javax.ws.rs.GET;
import javax.ws.rs.core.Response;

public interface Endpoint {

    @GET
    Response getResponse();

}