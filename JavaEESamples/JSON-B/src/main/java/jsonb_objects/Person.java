package jsonb_objects;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.config.PropertyOrderStrategy;

@JsonbPropertyOrder(PropertyOrderStrategy.REVERSE)
public class Person {

    @JsonbProperty("Forename")
    private String name;
    private String profession;
    private double salary;

    public Person() {

    }

    public Person(String name, String profession, double salary) {
        this.name = name;
        this.profession = profession;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @JsonbProperty("Yearly-Income")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
