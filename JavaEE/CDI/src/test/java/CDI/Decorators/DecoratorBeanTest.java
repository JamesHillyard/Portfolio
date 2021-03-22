package CDI.Decorators;

import CDI.Names.DefaultNamedBean;
import CDI.Scopes.ApplicationScopedBean;
import jakarta.inject.Inject;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableAutoWeld
class DecoratorBeanTest {

    //AppBean extends CustomBean which has a decorator, meaning that method is available for all beans extending customBean.
    @Inject
    ApplicationScopedBean appBean;
    @Inject
    DefaultNamedBean defaultBean;


    @Test
    public void testDecoratedBean(){
        assertNotNull(appBean.getRandomInt());
        assertNotNull(defaultBean.getRandomInt());
    }
}