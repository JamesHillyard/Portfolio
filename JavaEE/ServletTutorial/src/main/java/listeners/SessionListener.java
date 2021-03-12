package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *  Listens for when sessions are created and destroyed and outputs it to the server logs.
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent sessionEvent) {
    	//System.out.println("Session Created:: ID="+sessionEvent.getSession().getId());
    	System.out.println("Session Created");
    }

    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
    	//System.out.println("Session Destroyed:: ID="+sessionEvent.getSession().getId());
    	System.out.println("Session Destroyed");
    }
}