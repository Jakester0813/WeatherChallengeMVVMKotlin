package com.example.weatherchallengemvvmkotlin.data.models

import com.google.gson.annotations.SerializedName

class WeatherObject {
    @SerializedName("id") var id : Int = 0
    @SerializedName("main") var main : String? = null
    @SerializedName("description") var description : String? = null
    @SerializedName("icon") var icon : String? = null
}