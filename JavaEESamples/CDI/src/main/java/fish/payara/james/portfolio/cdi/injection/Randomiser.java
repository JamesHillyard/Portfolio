package fish.payara.james.portfolio.cdi.injection;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class Randomiser {

    int limit = 11;

    @Inject
    RandomGen gen;

    public int getNumber(){
        return gen.getRandomNumber(limit);
    }
}
