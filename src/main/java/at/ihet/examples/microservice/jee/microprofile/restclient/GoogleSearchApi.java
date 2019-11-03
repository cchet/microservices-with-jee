package at.ihet.examples.microservice.jee.microprofile.restclient;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * This interface specifies the external rest resource we want to use via a Rest-Client.
 * If we want tracing to be enabled on the client, then we need to create the client our self.
 *
 * @author Thomas Herzog <herzog.thomas81@gmail.com>
 * @since 11/1/2019
 */
@RegisterRestClient(configKey = "google.rest")
@Path("/")
public interface GoogleSearchApi {

    @Path("customsearch/v1")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    String search(@QueryParam("key") String key, @QueryParam("cx") String cx, @QueryParam("q") String searchString);
}
