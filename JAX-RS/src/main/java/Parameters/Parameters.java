package Parameters;

import javax.ws.rs.*;

@Path("parameters")
public class Parameters {
    /**
     * Here the first method will take a query parameter eg. http//localhost:8080/tutorial/parameters/query?input=james
     * The second method will take a path parameter eg. http://localhost:8080/tutorial/parameters/path/james
     */
    @GET
    @Path("query")
    public String returnQueryParameter(@DefaultValue("SAMPLE-DATA") @QueryParam("input") String input){
        return input;
    }

    @GET
    @Path("path/{input}")
    public String returnPathParameter(@PathParam("input") String input){
        return input;
    }

    /**
     * The form param annotation cannot be used with the GET method.
     */

    @POST
    @Path("form")
    public String returnFormParameter(@FormParam("input") String input, @FormParam("inputCheckbox") String checkbox){
        return input+" "+checkbox;
    }
}
