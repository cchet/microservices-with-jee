
package at.ihet.examples.microservice.jee.rest;

import at.ihet.examples.microservice.jee.config.Configuration;
import at.ihet.examples.microservice.jee.service.InfoService;
import org.eclipse.microprofile.opentracing.Traced;

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
@Traced
public class InfoResource {

    @Inject
    private InfoService infoService;

    @Path("/config")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Configuration getConfiguration() {
        return infoService.getConfiguration();
    }

    @Path("/info")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getInfo() {
        return infoService.getInfo();
    }

    @Path("/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfo(@QueryParam("query") String query) {
        return infoService.getInfo(query);
    }
}
