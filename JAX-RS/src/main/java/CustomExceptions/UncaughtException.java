package CustomExceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

//@Provider
public class UncaughtException extends Throwable implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable throwable) {
        return Response.status(500).entity("Something went wrong...\n"+throwable.getMessage()).type("text/plain").build();
    }
}
