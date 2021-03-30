package jdbc;

import java.io.Serializable;

public class Company implements Serializable {
    private int id;
    private String name;

    public Company(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return("Name: "+getName()+" ID: "+getId());
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
