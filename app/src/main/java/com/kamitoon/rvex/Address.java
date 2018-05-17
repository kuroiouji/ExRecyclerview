package com.kamitoon.rvex;

import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("street")
    private String street;

    @SerializedName("city")
    private String city;

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
}
