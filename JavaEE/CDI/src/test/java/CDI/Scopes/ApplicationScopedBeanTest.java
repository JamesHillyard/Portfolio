package CDI.Scopes;

import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
@EnableAutoWeld
class ApplicationScopedBeanTest {
    @Inject
    private ApplicationScopedBean appBean;

    @Test
    public void validRange(){
        int testValue = appBean.getRandomInt();
        assertTrue(0 <= testValue && testValue <= 100);
    }

    @Test
    public void isApplicationScoped(){
        int value1 = appBean.getRandomInt();
        int value2 = appBean.getRandomInt();
        assertSame(value1, value2);
    }
}