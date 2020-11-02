package com.example.weatherchallengemvvmkotlin.data.models

import com.google.gson.annotations.SerializedName

class MainObject {
    @SerializedName("temp") var temp: Double = 0.0
    @SerializedName("temp_min") var tempMin: Double = 0.0
    @SerializedName("temp_max") var tempMax: Double = 0.0
}