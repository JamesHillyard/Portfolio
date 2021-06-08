package fish.payara.james.portfolio.jaxrs.planetexample;

public class Planet {
    public int id;
    public String name;
    public double radius;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString(){
        return "Planet [id="+id+", name="+name+", radius"+radius+"]";
    }
}
