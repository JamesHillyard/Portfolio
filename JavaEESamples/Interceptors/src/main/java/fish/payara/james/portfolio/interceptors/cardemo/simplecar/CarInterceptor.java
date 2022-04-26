package fish.payara.james.portfolio.interceptors.cardemo.simplecar;

import fish.payara.james.portfolio.interceptors.MyInterceptorBinding;

import javax.annotation.PostConstruct;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@MyInterceptorBinding
public class CarInterceptor {

    final Logger LOGGER = Logger.getLogger(CarInterceptor.class.getName());

    @AroundConstruct
    public Object aroundConstruct(InvocationContext context) throws Exception {
        LOGGER.warning("Around Construct");
        return context.proceed();
    }

    @PostConstruct
    public void postConstruct(InvocationContext context) {
        LOGGER.warning("Post Construct");
    }

    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception {
        LOGGER.warning("Invoke");
        return context.proceed();
    }
}
