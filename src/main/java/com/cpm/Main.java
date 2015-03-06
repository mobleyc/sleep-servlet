package com.cpm;

import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class Main {

    public static void main(String[] args) throws Exception{
        String webPort = System.getenv("PORT");
        if(webPort == null || webPort.isEmpty()) {
            webPort = "8080";
        }

        URI baseUri = UriBuilder.fromUri("http://localhost/").port(Integer.valueOf(webPort)).build();
        ResourceConfig config = new ResourceConfig(SleepResource.class);
        JettyHttpContainerFactory.createServer(baseUri, config);
    }
}
