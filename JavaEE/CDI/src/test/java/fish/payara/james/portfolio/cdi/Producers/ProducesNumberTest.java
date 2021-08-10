package fish.payara.james.portfolio.cdi.Producers;

import fish.payara.james.portfolio.cdi.producers.ProducesNumber;
import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
@EnableAutoWeld
class ProducesNumberTest {
    @Inject
    ProducesNumber producer;

    @ParameterizedTest
    @ValueSource(ints = {3,6})
    public void testRandomNumber(int limit){
        int producedNumber = producer.produceRandomInt(limit);
        assertNotNull(producedNumber);
        assertTrue(0 <= producedNumber && producedNumber <= limit);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,1000})
    public void testNumberWithinLimits(int limit){
        for(int i=0; i<1000; i++){
            int producedNumber = producer.produceRandomInt(limit);
            assertTrue(0 <= producedNumber && producedNumber <= limit);
        }
    }
}