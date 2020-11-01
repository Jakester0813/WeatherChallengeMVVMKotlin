package com.example.weatherchallengemvvmkotlin.data.models;

import com.google.gson.annotations.SerializedName;

public class CloudObject {

    @SerializedName("all")
    long all;

    public long getAll() {
        return all;
    }

}
