package fish.payara.james.portfolio.servlettutorial.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *  A web listener which triggers when the web servlet lifecycle changes
 *  - Initialized will happen before any servlets or filters are initialized
 *  - Destroyed will happen after all servlets and filters have been destroyed
 */

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context Listener Starting.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context Listener Shutting Down.");
    }
}
