package com.examples.api.response;

import com.examples.api.entity.ResponseTuple;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thej on 12/9/16.
 */
public class LocByCityResponse implements Serializable {
    public List<ResponseTuple> responseTuples;

    public List<ResponseTuple> getResponseTuples() {
        return responseTuples;
    }

    public void setResponseTuples(List<ResponseTuple> responseTuples) {
        this.responseTuples = responseTuples;
    }

    public LocByCityResponse(List<ResponseTuple> responseTuples) {
        this.responseTuples = responseTuples;
    }

    public LocByCityResponse() {
    }
}
