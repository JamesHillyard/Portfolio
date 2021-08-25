package fish.payara.james.portfolio.arquillian.lifecycle;

import org.jboss.arquillian.core.spi.LoadableExtension;

public class LifecycleExtension implements LoadableExtension {

    @Override
    public void register(ExtensionBuilder builder) {
        builder.observer(LifecycleExecutor.class);
    }
}
