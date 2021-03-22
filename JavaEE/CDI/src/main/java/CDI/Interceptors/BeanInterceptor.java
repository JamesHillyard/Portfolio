package CDI.Interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundConstruct;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.io.Serializable;
import java.util.logging.Logger;

@Interceptor
@MyInterceptorBinding
@Priority(Interceptor.Priority.APPLICATION)
public class BeanInterceptor implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(BeanInterceptor.class.getName());

    @AroundInvoke
    public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
        final Object result = invocationContext.proceed();
        LOGGER.info(() -> String.format("Invoking custom bean method %s. Result: %s",
                invocationContext.getMethod().getName(), result));
        return result;
    }

    @AroundConstruct
    public Object logBeanCreation(InvocationContext invocationContext) throws Exception {
        final Object result = invocationContext.proceed();
        LOGGER.info(() -> String.format("Custom bean constructed: %s", result));
        return result;
    }
}
