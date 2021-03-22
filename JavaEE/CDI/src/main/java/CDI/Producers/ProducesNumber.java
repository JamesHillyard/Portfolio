package CDI.Producers;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.Produces;

import java.util.Random;

@Dependent
public class ProducesNumber {

    @Produces
    public int produceRandomInt(int limit){
        Random random = new Random();
        return random.nextInt(limit);
    }
}
