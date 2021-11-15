package jsonb_objects;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class House {

    private String roofColour;
    private int numberOfRooms;
    private double value;

    @JsonbCreator
    public House(@JsonbProperty("Roof Colour") String roofColour,
                 @JsonbProperty("Number Of Rooms") int numberOfRooms,
                 @JsonbProperty("Property Value") double value) {

        this.roofColour = roofColour;
        this.numberOfRooms = numberOfRooms;
        this.value = value;
    }

    public String getRoofColour() {
        return roofColour;
    }

    public void setRoofColour(String roofColour) {
        this.roofColour = roofColour;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
