
package at.ihet.examples.microservice.jee.microprofile.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.json.bind.annotation.JsonbTransient;

/**
 * This is the configuration class which bundles the service configurations, we can use within our business logic.
 * There is no binding to any specific configuration source.
 *
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 10/27/2019
 */
@Dependent
public class Configuration {

    @Inject
    @ConfigProperty(name = "info.text")
    private String infoText;

    @Inject
    @ConfigProperty(name = "google.rest.apiKey")
    private String apiKey;

    @Inject
    @ConfigProperty(name = "google.rest.cx")
    private String cx;

    // If we want to programmatically access configurations
    @Inject
    private Config config;

    public String getInfoText() {
        return infoText;
    }

    @JsonbTransient
    public String getApiKey() {
        return apiKey;
    }

    public String getCx() {
        return cx;
    }

    @JsonbTransient
    public String getInfoProgrammatically() {
        // Useful when there are properties with dynamic keys
        // E.g.: rest.[customer].baseUrl
        return config.getValue("info.text", String.class);
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "infoText='" + infoText + '\'' +
                '}';
    }
}
