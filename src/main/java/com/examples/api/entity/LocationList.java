package com.examples.api.entity;

import java.util.List;

/**
 * Created by thej on 12/9/16.
 */
public class LocationList {
    List<Location> locationList;

    public LocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }
}
