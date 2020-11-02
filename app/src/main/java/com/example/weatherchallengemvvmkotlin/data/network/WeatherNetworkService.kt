package com.example.weatherchallengemvvmkotlin.data.network

import com.example.weatherchallengemvvmkotlin.data.models.WeatherResponse
import com.example.weatherchallengemvvmkotlin.util.WeatherConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class WeatherNetworkService(var mAPIService: WeatherService) {
    fun getWeatherDetails(query: String?, onResponse: Consumer<in WeatherResponse?>?, onError: Consumer<in Throwable?>?): Disposable? {
        return mAPIService.getWeather(query, WeatherConstants.API_KEY)
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(onResponse, onError)
    }
}