package fish.payara.james.portfolio.interceptors.ejbtimer;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.time.LocalDateTime;
import java.util.logging.Logger;

@Stateless
public class TimerBean {

    final Logger LOGGER = Logger.getLogger(TimerBean.class.getName());

    @Interceptors(TimerInterceptor.class)
    @Schedule(second = "*/15", minute = "*", hour = "*")
    public void fifteenSeconds() {
        LOGGER.info(LocalDateTime.now().toString());
    }

    @Interceptors(TimerInterceptor.class)
    @Schedule(second = "*/30", minute = "*", hour = "*")
    public void thirtySeconds() {
        LOGGER.info(LocalDateTime.now().toString());
    }
}
