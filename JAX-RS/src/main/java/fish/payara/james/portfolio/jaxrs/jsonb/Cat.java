package fish.payara.james.portfolio.jaxrs.jsonb;


import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.config.PropertyOrderStrategy;

/**
 * javaee.github.io/jsonb-spec/users-guide.html
 */

@JsonbPropertyOrder(PropertyOrderStrategy.LEXICOGRAPHICAL)
public class Cat {
    //This jsonb property tag will mean when the json object is outputted it has the tag name instead of the field name
    @JsonbProperty("Cat Name")
    private String name;
    private String colour;
    private boolean domesticated;

    //JSON-B Requires a default constructor
    public Cat(){
        super();
    }

    public Cat(String name, String colour, boolean domesticated){
        this.name = name;
        this.colour = colour;
        this.domesticated = domesticated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isDomesticated() {
        return domesticated;
    }

    public void setDomesticated(boolean domesticated) {
        this.domesticated = domesticated;
    }
}
