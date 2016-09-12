package com.examples.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by thej on 12/9/16.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location implements Serializable{
    @NotEmpty
    long _id;

    String key;
    String name;
    String fullName;
    String iata_airport_code;
    String type;
    String country;

    @JsonProperty("geo_position")
    GeoPosition geoPosition;
    long locationId;
    boolean inEurope;
    int countryId;
    String countryCode;
    boolean coreCountry;
    long distance;
    Map<String, String> names;
    Map<String, String> alternativeNames;

    public Location() {
    }

    public Location(long _id, String key, String name, String fullName, String iata_airport_code, String type, String country, GeoPosition geoPosition, long locationId, boolean inEurope, int countryId, String countryCode, boolean coreCountry, long distance, Map<String, String> names, Map<String, String> alternativeNames) {
        this._id = _id;
        this.key = key;
        this.name = name;
        this.fullName = fullName;
        this.iata_airport_code = iata_airport_code;
        this.type = type;
        this.country = country;
        this.geoPosition = geoPosition;
        this.locationId = locationId;
        this.inEurope = inEurope;
        this.countryId = countryId;
        this.countryCode = countryCode;
        this.coreCountry = coreCountry;
        this.distance = distance;
        this.names = names;
        this.alternativeNames = alternativeNames;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIata_airport_code() {
        return iata_airport_code;
    }

    public void setIata_airport_code(String iata_airport_code) {
        this.iata_airport_code = iata_airport_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeoPosition getGeoPosition() {
        return geoPosition;
    }


    @JsonProperty("geo_position")
    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public boolean isInEurope() {
        return inEurope;
    }

    public void setInEurope(boolean inEurope) {
        this.inEurope = inEurope;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isCoreCountry() {
        return coreCountry;
    }

    public void setCoreCountry(boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public Map<String, String> getNames() {
        return names;
    }

    public void setNames(Map<String, String> names) {
        this.names = names;
    }

    public Map<String, String> getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(Map<String, String> alternativeNames) {
        this.alternativeNames = alternativeNames;
    }
}
