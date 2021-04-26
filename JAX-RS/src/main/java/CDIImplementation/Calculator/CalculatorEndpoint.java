package CDIImplementation.Calculator;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("calculate")
public class CalculatorEndpoint {

    @Inject
    private CalculatorService calculatorService;

    @GET
    @Path("doubleOf/{number}")
    @Produces("text/plain")
    public Integer doubleOf(@PathParam("number") int number){
        return calculatorService.doubleOf(number);
    }
}
