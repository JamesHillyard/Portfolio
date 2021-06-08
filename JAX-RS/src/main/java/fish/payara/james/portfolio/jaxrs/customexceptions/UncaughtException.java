package fish.payara.james.portfolio.jaxrs.customexceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * The provider annotation is used by JAX-RS to examine incoming and outgoing messages. This allows it to be used for
 * filtering and exception handling.
 */
@Provider
public class UncaughtException extends Throwable implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        return Response.status(500).entity("Something went wrong...\n"+throwable.getMessage()).type("text/plain").build();
    }
}
