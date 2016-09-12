package com.examples.api.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by thej on 12/9/16.
 */

@JsonPropertyOrder({"_id","name", "type","latitude","longitude"})
public class ResponseTuple {
    long _id;
    String name;
    String type;
    double latitude;
    double longitude;

    public ResponseTuple() {
    }

    public ResponseTuple(Location loc) {
        this._id = loc.get_id();
        this.name = loc.getName();
        this.type = loc.getType();
        this.longitude = loc.getGeoPosition().getLongitude();
        this.latitude = loc.getGeoPosition().getLatitude();
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public ResponseTuple(long _id, String name, String type, double latitude, double longitude) {
        this._id = _id;
        this.name = name;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
