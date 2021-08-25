package fish.payara.james.portfolio.arquillian.cdi;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import java.io.Serializable;

@ApplicationScoped
public class RandomNumberGenerator implements Serializable {
    private java.util.Random random = new java.util.Random(System.currentTimeMillis());

    @Produces
    public int getRandomNumber() {
        return random.nextInt(100);
    }
}
