package cdi;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class CdiBean implements Serializable {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void increment(){
        counter++;
    }
}