package com.examples.api.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by thej on 12/9/16.
 */
public class LocClientHealthCheck extends HealthCheck {
    private final String version;

    public LocClientHealthCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy("OK with version: " + this.version);
    }
}
