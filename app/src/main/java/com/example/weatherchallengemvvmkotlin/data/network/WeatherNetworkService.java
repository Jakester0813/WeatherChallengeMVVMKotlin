package com.example.weatherchallengemvvmkotlin.data.network;

import com.example.weatherchallengemvvmkotlin.data.models.WeatherResponse;
import com.example.weatherchallengemvvmkotlin.util.WeatherConstants;

import org.jetbrains.annotations.Nullable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class WeatherNetworkService {

    WeatherService mAPIService;

    public WeatherNetworkService(WeatherService apiService) {
        this.mAPIService = apiService;
    }

    public Disposable getWeatherDetails(String query, Consumer<? super WeatherResponse> onResponse, @Nullable Consumer<? super Throwable> onError) {
        return mAPIService.getWeather(query, WeatherConstants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onResponse, onError);
    }
}
