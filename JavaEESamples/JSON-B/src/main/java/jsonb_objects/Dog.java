package jsonb_objects;

import javax.enterprise.context.Dependent;

@Dependent
public class Dog {
    public String name;
    public Integer age;
    public boolean bitable;

    public Dog(){

    }

    public Dog(String name, Integer age, boolean bitable) {
        this.name = name;
        this.age = age;
        this.bitable = bitable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBitable() {
        return bitable;
    }

    public void setBitable(boolean bitable) {
        this.bitable = bitable;
    }
}
