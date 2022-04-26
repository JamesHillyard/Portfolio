package fish.payara.james.portfolio.interceptors.cardemo.jaxrscar;

import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;

@ApplicationScoped
@Path("car")
@Interceptors(JaxRSCarInterceptor.class)
public class JaxRSCarEndpoint {

    ArrayList<JaxRSCar> cars = new ArrayList<>();

    @POST
    @Path("/new/{colour}/{engineSize}")
    public void createCar(@PathParam("colour") String colour, @PathParam("engineSize") double engineSize) {
        cars.add(new JaxRSCar(colour, engineSize));
    }

    @GET
    @Path("/{colour}/{engineSize}")
    public String getCar(@PathParam("colour") String colour, @PathParam("engineSize") double engineSize) {
        for (JaxRSCar car : cars) {
            if (car.getColour().equals(colour) && car.getEngineSize() == engineSize) {
                return car.toString();
            }
        }
        return "Car not found";
    }

}
