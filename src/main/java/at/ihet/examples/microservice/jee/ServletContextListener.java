
package at.ihet.examples.microservice.jee;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 10/27/2019
 */
@WebListener("servletContextInitializer")
public class ServletContextListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext destroyed");

    }
}
