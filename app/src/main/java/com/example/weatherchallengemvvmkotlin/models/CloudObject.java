package com.example.weatherchallengemvvmkotlin.models;

import com.google.gson.annotations.SerializedName;

public class CloudObject {

    @SerializedName("all")
    long all;

    public long getAll(){
        return all;
    }

}
