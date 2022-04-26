package fish.payara.james.portfolio.interceptors.cardemo.jaxrscar;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.List;

public class JaxRSCarInterceptor {

    final List<String> bannedColours = Arrays.asList("Red", "Yellow", "Green");

    @AroundInvoke
    public Object aroundInvoke(InvocationContext context) throws Exception {
        if (bannedColours.contains(context.getParameters()[0])) {
            throw new IllegalArgumentException("That colour is banned.");
        }
        return context.proceed();
    }
}
