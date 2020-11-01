package com.example.weatherchallengemvvmkotlin.data.models;

import com.google.gson.annotations.SerializedName;

public class MainObject {

    @SerializedName("temp")
    double temp;

    @SerializedName("pressure")
    double pressure;

    @SerializedName("humidity")
    long humidity;

    @SerializedName("temp_min")
    double tempMin;

    @SerializedName("temp_max")
    double tempMax;

    @SerializedName("sea_level")
    double seaLevel;

    @SerializedName("grnd_level")
    double groundLevel;

    public double getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getSeaLevel() {
        return seaLevel;
    }

    public double getGroundLevel() {
        return groundLevel;
    }

}
