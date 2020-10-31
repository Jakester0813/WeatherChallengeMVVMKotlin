package com.example.weatherchallengemvvmkotlin.network;

import com.example.weatherchallengemvvmkotlin.models.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("data/2.5/weather")
    Observable<WeatherResponse> getWeather(@Query("q") String query, @Query("APPID") String appId);
}
