package at.ihet.examples.microservice.jee.service;

import at.ihet.examples.microservice.jee.config.Configuration;
import at.ihet.examples.microservice.jee.restclient.GoogleSearchApi;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;

@ApplicationScoped
@Traced
public class InfoService {
    // This is the CDI managed configuration instance
    @Inject
    private Configuration configuration;

    // This is a CDI managed Rest-Client
    @Inject
    private GoogleSearchApi searchApi;

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getInfo() {
        return configuration.getInfoText();
    }

    public String getInfo(@QueryParam("query") String query) {
        return searchApi.search(configuration.getApiKey(), configuration.getCx(), query);
    }
}
