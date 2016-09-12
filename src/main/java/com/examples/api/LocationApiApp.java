package com.examples.api;

import com.examples.api.config.LocationApiConfiguration;
import com.examples.api.healthcheck.LocClientHealthCheck;
import com.examples.api.resource.ClientResource;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;


/**
 * Created by thej on 12/9/16.
 */
public class LocationApiApp extends Application<LocationApiConfiguration> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(LocationApiApp.class);

    public static void main(String[] args) {
        try {
            new LocationApiApp().run(args);
        } catch (Exception e) {
            LOGGER.error("Exception while running location api", e);
        }
    }

    @Override
    public void initialize(Bootstrap<LocationApiConfiguration> b) {

    }

    @Override
    public void run(LocationApiConfiguration locationApiConfiguration, final Environment environment) throws Exception {
        LOGGER.info("Method App#run() called");
        System.out.println("Hello world, by Dropwizard!");
        System.out.println("Location API: " + locationApiConfiguration.getGoEuroApi());
        System.out.println("jersey details: "+ locationApiConfiguration.getJerseyClientConfiguration().getWorkQueueSize());

        final Client client = new JerseyClientBuilder(environment).using(locationApiConfiguration.getJerseyClientConfiguration())
                .build(getName());
        final LocClientHealthCheck healthCheck = new LocClientHealthCheck(locationApiConfiguration.getVersion());
        environment.jersey().register(new ClientResource(locationApiConfiguration.getGoEuroApi(), client));
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(healthCheck);
    }
}
