package fish.payara.james.portfolio.arquillian.lifecycle;

import org.jboss.arquillian.container.spi.event.container.AfterDeploy;
import org.jboss.arquillian.container.spi.event.container.AfterUnDeploy;
import org.jboss.arquillian.container.spi.event.container.BeforeDeploy;
import org.jboss.arquillian.container.spi.event.container.BeforeUnDeploy;
import org.jboss.arquillian.core.api.annotation.Observes;
import org.jboss.arquillian.test.spi.TestClass;

import java.util.logging.Logger;

public class LifecycleExecutor {

    private static final Logger LOGGER = Logger.getLogger(LifecycleExecutor.class.getName());

    public void executeBeforeDeploy(@Observes BeforeDeploy event, TestClass testClass) {
        execute("BeforeDeploy");
    }

    public void executeAfterDeploy(@Observes AfterDeploy event, TestClass testClass) {
        execute("AfterDeploy");
    }

    public void executeBeforeUnDeploy(@Observes BeforeUnDeploy event, TestClass testClass) {
        execute("BeforeUnDeploy");
    }

    public void executeAfterUnDeploy(@Observes AfterUnDeploy event, TestClass testClass) {
        execute("AfterUnDeploy");
    }

    private void execute(String lifecyclePhase) {
        LOGGER.info("Phase "+lifecyclePhase);
    }
}
