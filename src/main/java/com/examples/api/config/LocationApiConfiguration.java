package com.examples.api.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


/**
 * Created by thej on 12/9/16.
 */
public class LocationApiConfiguration extends Configuration {

    @NotEmpty
    private String version;

    @JsonProperty
    @NotEmpty
    public String goEuroApi;

    @Valid
    @NotNull
    @JsonProperty("jerseyClient")
    private JerseyClientConfiguration jerseyClientConfiguration = new JerseyClientConfiguration();

    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return jerseyClientConfiguration;
    }

    public LocationApiConfiguration(String goEuroApi) {
        this.goEuroApi = goEuroApi;
    }

    public String getGoEuroApi() {
        return goEuroApi;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setGoEuroApi(String goEuroApi) {
        this.goEuroApi = goEuroApi;
    }

    public void setJerseyClientConfiguration(JerseyClientConfiguration jerseyClientConfiguration) {
        this.jerseyClientConfiguration = jerseyClientConfiguration;
    }

    public LocationApiConfiguration() {
    }
}
