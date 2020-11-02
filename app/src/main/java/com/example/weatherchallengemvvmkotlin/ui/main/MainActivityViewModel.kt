package com.example.weatherchallengemvvmkotlin.ui.main

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.weatherchallengemvvmkotlin.WeatherMVVMKotlinApplication
import com.example.weatherchallengemvvmkotlin.data.models.WeatherData
import com.example.weatherchallengemvvmkotlin.data.models.WeatherResponse
import com.example.weatherchallengemvvmkotlin.data.network.WeatherNetworkService
import com.example.weatherchallengemvvmkotlin.data.network.WeatherService
import com.example.weatherchallengemvvmkotlin.util.WeatherConstants
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    @JvmField
    @Inject
    var weatherService: WeatherNetworkService? = null
    protected var disposables = CompositeDisposable()
    var weatherPrefs: SharedPreferences
    var weatherData = MutableLiveData<WeatherData>()
        protected set

    fun retrieveWeather(query: String?) {
        weatherPrefs.edit().putString(WeatherConstants.LOCATION_DATA, query).apply()
        getLocationData(query)
    }

    private fun getLocationData(query: String?) {
        weatherService!!.getWeatherDetails(query,
                { weatherResponse: WeatherResponse? -> weatherData.postValue(WeatherData.from(weatherResponse!!, getApplication(), false)) },
                { throwable: Throwable? -> weatherData.postValue(WeatherData.from(null, getApplication(), true)) })?.let { disposables.add(it) }
    }

    fun isInputAZipCode(input: String): Boolean {
        return isParsableAsInt(input) && input.length == 5
    }

    fun isInputACity(input: String): Boolean {
        val regex = "[ a-zA-Z]+".toRegex()
        return regex.matches(input)
    }

    private fun isParsableAsInt(input: String): Boolean {
        try {
            Integer.valueOf(input)
        } catch (e: NumberFormatException) {
            return false
        }
        return true
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    init {
        WeatherMVVMKotlinApplication.instance.appComponent?.inject(this)
        weatherPrefs = application.getSharedPreferences(WeatherConstants.PREFS_NAME, Context.MODE_PRIVATE)
        if (weatherPrefs.contains(WeatherConstants.LOCATION_DATA)) retrieveWeather(weatherPrefs.getString(WeatherConstants.LOCATION_DATA, ""))
    }
}