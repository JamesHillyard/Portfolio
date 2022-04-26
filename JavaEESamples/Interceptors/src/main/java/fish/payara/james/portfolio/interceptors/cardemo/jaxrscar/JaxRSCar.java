package fish.payara.james.portfolio.interceptors.cardemo.jaxrscar;

import fish.payara.james.portfolio.interceptors.cardemo.Car;

import javax.interceptor.Interceptors;

@Interceptors(JaxRSCarInterceptor.class)
public class JaxRSCar extends Car {
    public JaxRSCar(String colour, double engineSize) {
        super(colour, engineSize);
    }
}
