package fish.payara.james.portfolio.interceptors.ejbtimer;

import fish.payara.james.portfolio.interceptors.MyInterceptorBinding;

import javax.interceptor.AroundTimeout;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@MyInterceptorBinding
public class TimerInterceptor {

    final Logger LOGGER = Logger.getLogger(TimerInterceptor.class.getName());

    @AroundTimeout
    public Object aroundTimeout(InvocationContext context) throws Exception {
        if (!context.getMethod().toString().contains("fifteenSeconds()")) {
            return context.proceed();
        }
        return null;
    }
}
