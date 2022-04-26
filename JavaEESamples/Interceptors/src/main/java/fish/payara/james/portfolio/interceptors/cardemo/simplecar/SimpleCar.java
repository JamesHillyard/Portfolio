package fish.payara.james.portfolio.interceptors.cardemo.simplecar;

import fish.payara.james.portfolio.interceptors.cardemo.Car;

import javax.interceptor.Interceptors;

@Interceptors(CarInterceptor.class)
public class SimpleCar extends Car {

}
