package com.example.weatherchallengemvvmkotlin.data.network;

import com.example.weatherchallengemvvmkotlin.data.models.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {

    @GET("data/2.5/weather")
    Observable<WeatherResponse> getWeather(@Query("q") String query, @Query("APPID") String appId);
}
