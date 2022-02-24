package james.portfolio.jakartaconcurrency.managedthreadfactory;

import james.portfolio.jakartaconcurrency.MyJob;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("concurrency")
public class FactoryResource {

    @Resource(name = "java:comp/DefaultManagedThreadFactory")
    ManagedThreadFactory threadFactory;

    @GET
    @Path("threadInfo")
    @Produces(MediaType.TEXT_PLAIN)
    public String simpleJob() {
        Thread thread = threadFactory.newThread(new MyJob(100));
        thread.start();
        return "Thread Name: " + thread.getName()
                + "\nThread State: " + thread.getState()
                + "\nThread Group: " + thread.getThreadGroup()
                + "\nThread is Alive: " + thread.isAlive()
                + "\nThread Priority: " + thread.getPriority();
    }
}
