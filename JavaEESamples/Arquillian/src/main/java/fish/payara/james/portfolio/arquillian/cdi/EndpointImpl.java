package fish.payara.james.portfolio.arquillian.cdi;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.Serializable;

import static javax.ws.rs.core.Response.noContent;

@Path("/beanCounter")
public class EndpointImpl implements Endpoint, Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    CdiBean bean;

    @Override
    public Response getResponse() {
        bean.increment();
        return noContent().status(200).build();
    }

    @Path("/largeIncrement")
    public Response largeIncrement(){
        bean.setCounter(100);
        return noContent().status(200).build();
    }

}