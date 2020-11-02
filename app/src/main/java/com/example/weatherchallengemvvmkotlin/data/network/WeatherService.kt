package com.example.weatherchallengemvvmkotlin.data.network

import com.example.weatherchallengemvvmkotlin.data.models.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("data/2.5/weather")
    fun getWeather(@Query("q") query: String?, @Query("APPID") appId: String?): Observable<WeatherResponse?>?
}