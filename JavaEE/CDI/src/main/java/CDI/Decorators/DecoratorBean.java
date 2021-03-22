package CDI.Decorators;

import CDI.CustomBean;
import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.inject.Inject;
import jakarta.interceptor.Interceptor;

import java.util.logging.Logger;

@Decorator
@Priority(Interceptor.Priority.APPLICATION)
public class DecoratorBean extends CustomBean {

    private static final Logger LOGGER = Logger.getLogger(DecoratorBean.class.getName());

    @Inject
    @Delegate
    private CustomBean delegate;

    @Override
    public Integer getRandomInt() {
        final int result = delegate.getRandomInt();
        LOGGER.info(() -> String.format("Getting random integer. Result: %s", result));
        return result;
    }

}
