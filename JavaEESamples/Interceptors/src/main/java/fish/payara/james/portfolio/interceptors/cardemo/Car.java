package fish.payara.james.portfolio.interceptors.cardemo;

import java.util.logging.Logger;

public abstract class Car {

    final Logger LOGGER = Logger.getLogger(Car.class.getName());

    String colour;
    double engineSize;

    public Car() {
        this.colour = "Blue";
        this.engineSize = 1.25;
        LOGGER.info("Car Created");
    }

    public Car(String colour, double engineSize) {
        this.colour = colour;
        this.engineSize = engineSize;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "Car{" +
                "colour='" + colour + '\'' +
                ", engineSize=" + engineSize + 'L' +
                '}';
    }
}
