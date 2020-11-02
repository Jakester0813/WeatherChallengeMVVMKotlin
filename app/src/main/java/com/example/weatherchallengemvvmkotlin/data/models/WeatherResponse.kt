package com.example.weatherchallengemvvmkotlin.data.models

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class WeatherResponse {
    @SerializedName("weather") var weatherObjList : ArrayList<WeatherObject>? = null
    @SerializedName("base") var base :String? = null
    @SerializedName("main") var main : MainObject? = null
    @SerializedName("dt") var dt : Long = 0
    @SerializedName("sys") var sysObject : SysObject? = null
    @SerializedName("id") var id : Long = 0
    @SerializedName("name") var name : String? = null
    @SerializedName("code") var code : Int = 0
}