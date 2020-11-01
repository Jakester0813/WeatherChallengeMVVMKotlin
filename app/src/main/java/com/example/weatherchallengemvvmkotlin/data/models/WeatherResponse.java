package com.example.weatherchallengemvvmkotlin.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherResponse {

    @SerializedName("coord")
    CoordinateObject coord;

    @SerializedName("weather")
    ArrayList<WeatherObject> weatherObjs;

    @SerializedName("base")
    String base;

    @SerializedName("main")
    MainObject main;

    @SerializedName("wind")
    WindObject wind;

    @SerializedName("clouds")
    CloudObject cloud;

    @SerializedName("dt")
    long dt;

    @SerializedName("sys")
    SysObject mSysObject;

    @SerializedName("id")
    long id;

    @SerializedName("name")
    String name;

    @SerializedName("cod")
    int code;

    public CoordinateObject getCoord() {
        return coord;
    }

    public ArrayList<WeatherObject> getWeatherObjects() {
        return weatherObjs;
    }

    public String getBase() {
        return base;
    }

    public MainObject getMain() {
        return main;
    }

    public WindObject getWind() {
        return wind;
    }

    public CloudObject getCloud() {
        return cloud;
    }

    public long getDt() {
        return dt;
    }

    public SysObject getSysObject() {
        return mSysObject;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
