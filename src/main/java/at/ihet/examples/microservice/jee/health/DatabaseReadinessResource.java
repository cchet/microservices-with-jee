package at.ihet.examples.microservice.jee.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

/**
 * Be aware, Services(Kubernetes)/Routes(Openshift) are closed when readiness probe fails, but containers are not killed!!!!
 *
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 10/27/2019
 */
@ApplicationScoped
@Readiness
public class DatabaseReadinessResource implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        // Perform readiness check for database
        return HealthCheckResponse.named("database-ready").up().build();
    }
}