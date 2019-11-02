
package at.ihet.examples.microservice.jee;

import at.ihet.examples.microservice.jee.config.Configuration;
import at.ihet.examples.microservice.jee.restclient.GoogleSearchApi;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 10/27/2019
 */
@Path("/")
public class InfoResource {

    // This is the CDI managed configuration instance
    @Inject
    private Configuration configuration;

    // This is a CDI managed Rest-Client
    @Inject
    private GoogleSearchApi searchApi;

    @Path("/config")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Configuration getConfiguration() {
        return configuration;
    }

    @Path("/info")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo() {
        return configuration.getInfoText();
    }

    @Path("/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfo(@QueryParam("query") String query) {
        return searchApi.search(configuration.getApiKey(), configuration.getCx(), query);
    }
}
