package CDI.Injection;

import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@EnableAutoWeld
class RandomiserTest {
    @Inject
    Randomiser rand;

    @Test
    public void randomNumberTest(){
        int number = rand.getNumber();
        assertNotNull(number);
        System.out.println(number);
    }
}