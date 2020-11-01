package com.example.weatherchallengemvvmkotlin.data.models;

import com.google.gson.annotations.SerializedName;

public class CoordinateObject {

    @SerializedName("lon")
    double lon;

    @SerializedName("lat")
    double lat;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

}
