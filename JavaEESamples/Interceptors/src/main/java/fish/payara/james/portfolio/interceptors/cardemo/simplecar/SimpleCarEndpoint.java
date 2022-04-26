package fish.payara.james.portfolio.interceptors.cardemo.simplecar;

import javax.interceptor.Interceptors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/simplecars")
@Interceptors(CarInterceptor.class)
public class SimpleCarEndpoint {
    SimpleCar car;
    public SimpleCarEndpoint() {
        this.car = new SimpleCar();
    }

    @GET
    public String getCarDetails() {
        return car.toString();
    }


}
