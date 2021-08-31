package jsonb_objects;

import javax.json.bind.annotation.JsonbNillable;
import javax.json.bind.annotation.JsonbTransient;

@JsonbNillable
public class Car {

    public double engineSize;
    public int numberOfDoors;
    @JsonbTransient
    public int yearManufactured;
    public String colour;

    public Car() {

    }

    public Car(double engineSize, int numberOfDoors) {
        this.engineSize = engineSize;
        this.numberOfDoors = numberOfDoors;
    }

    public Car(double engineSize, int numberOfDoors, int yearManufactured, String colour) {
        this.engineSize = engineSize;
        this.numberOfDoors = numberOfDoors;
        this.yearManufactured = yearManufactured;
        this.colour = colour;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(int yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    @JsonbTransient
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
