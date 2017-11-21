package com.example.acimo.devicedetector.models;


import java.util.List;

public class FitnessGymsModel {
    private String url;
    private String id;
    private int active;
    private String adress1;
    private String adress2;
    private String city;
    private String zip;
    private String country;

    public FitnessGymsModel(String url, String id, int active, String adress1, String adress2, String city, String zip, String country) {
        this.url = url;
        this.id = id;
        this.active = active;
        this.adress1 = adress1;
        this.adress2 = adress2;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1;
    }

    public String getAdress2() {
        return adress2;
    }

    public void setAdress2(String adress2) {
        this.adress2 = adress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }




}
