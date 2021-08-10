package fish.payara.james.portfolio.cdi.injection;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.Produces;

import java.util.Random;

@Dependent
public class RandomGen {

    @Produces
    public int getRandomNumber(int limit){
        Random random = new Random();
        return random.nextInt(limit);
    }
}
