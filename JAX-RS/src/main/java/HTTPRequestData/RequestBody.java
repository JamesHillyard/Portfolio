package HTTPRequestData;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/body")
public class RequestBody {

    /**
     * The only parameter without annotation will be a container for the request body.
     * @return
     */
    @POST
    public String viewMethodBody(String body) {
        return body;
    }
}
