package com.example.weatherchallengemvvmkotlin.data.models

import com.google.gson.annotations.SerializedName

class SysObject {
    @SerializedName("message") var message : Double = 0.0;
    @SerializedName("country") var country : String? = null
    @SerializedName("sunrise") var sunrise : Long = 0
    @SerializedName("sunset") var sunset : Long = 0
}