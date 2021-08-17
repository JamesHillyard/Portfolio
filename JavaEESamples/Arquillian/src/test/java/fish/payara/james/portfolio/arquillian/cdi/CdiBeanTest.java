package fish.payara.james.portfolio.arquillian.cdi;

import cdi.CdiBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.jboss.shrinkwrap.api.ShrinkWrap.create;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class CdiBeanTest {

    @Deployment
    public static WebArchive createDeployment() {
        return create(WebArchive.class, "arquillian-test.war")
                .addPackage(CdiBean.class.getPackage())
                .addAsWebInfResource("web.xml");
    }

    @Inject
    private CdiBean bean;

    @Test
    public void testCdiBeanInjection() {
        assertNotNull(bean);
        assertEquals(0, bean.getCounter());
    }

}