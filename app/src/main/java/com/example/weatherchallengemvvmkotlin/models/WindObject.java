package com.example.weatherchallengemvvmkotlin.models;

import com.google.gson.annotations.SerializedName;

public class WindObject {

    @SerializedName("speed")
    double speed;

    @SerializedName("deg")
    double deg;

    public double getSpeed(){
        return speed;
    }

    public double getDeg(){
        return deg;
    }

}
