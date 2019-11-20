/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lue.jeptags.entity;

/**
 *
 * @author lue
 */
public class SellerStoreAddress {

    private String street;
    private String city;
    private String state;
    private String postcode;
    private String country_id;
    private String geo_latitude;
    private String geo_longitude;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getGeo_latitude() {
        return geo_latitude;
    }

    public void setGeo_latitude(String geo_latitude) {
        this.geo_latitude = geo_latitude;
    }

    public String getGeo_longitude() {
        return geo_longitude;
    }

    public void setGeo_longitude(String geo_longitude) {
        this.geo_longitude = geo_longitude;
    }
    
    
}
