package at.ihet.examples.microservice.jee.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;

/**
 * Be aware, containers are KILLED when liveness probe fails!!!!
 *
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 10/27/2019
 */
@ApplicationScoped
@Liveness
public class DatabaseLivenessResource implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        // Perform liveness check for database
        return HealthCheckResponse.named("database-alive").up().build();
    }
}