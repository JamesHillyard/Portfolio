package jsonb_objects;

import javax.json.bind.annotation.JsonbProperty;

public class NullDog extends Dog {

    @JsonbProperty(nillable = true)
    private String collarColour;

    public NullDog(String name, Integer age, boolean bitable, String collarColour) {
        super(name, age, bitable);
        this.collarColour = collarColour;
    }

    public String getCollarColour() {
        return collarColour;
    }

    public void setCollarColour(String collarColour) {
        this.collarColour = collarColour;
    }
}
