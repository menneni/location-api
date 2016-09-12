package com.examples.api.response;

import java.io.Serializable;

/**
 * Created by thej on 12/9/16.
 */
public class LocApiResponse implements Serializable {
    public String code;
    public String status;
    public LocByCityResponse locByCityResponse;

    public LocApiResponse() {
    }

    public LocApiResponse(LocByCityResponse locByCityResponse) {
        this.code = "200";
        this.status = "ok";
        this.locByCityResponse = locByCityResponse;
    }

    public LocApiResponse(String code, String status, LocByCityResponse locByCityResponse) {
        this.code = code;
        this.status = status;
        this.locByCityResponse = locByCityResponse;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocByCityResponse getLocByCityResponse() {
        return locByCityResponse;
    }

    public void setLocByCityResponse(LocByCityResponse locByCityResponse) {
        this.locByCityResponse = locByCityResponse;
    }
}
