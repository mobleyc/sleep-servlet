package com.cpm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/sleep")
public class SleepResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sleep(@Context UriInfo ui,
                          @Context HttpHeaders headers) throws InterruptedException {

        String response = "OK";
        int millis = 100;
        List<String> params = ui.getQueryParameters().get("millis");
        if (null != params) {
            millis = Integer.valueOf(params.get(0));
        }

        Thread.sleep(millis);

        List<String> hValues = headers.getRequestHeader("X-Echo");
        if ((null != hValues) && !hValues.get(0).isEmpty()) {
            response = hValues.get(0);
        }

        return Response.status(200)
                .entity(String.format("echo: %s, sleep time: %d", response, millis))
                .build();
    }
}
