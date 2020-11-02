package com.example.weatherchallengemvvmkotlin.data.models

import android.content.Context
import com.example.weatherchallengemvvmkotlin.R
import com.example.weatherchallengemvvmkotlin.util.WeatherFunctions

class WeatherData {
    var isErrorThrown: Boolean = false
    var location: String? = null
    var temperature: String? = null
    var imageUrl: String? = null
    var mainWeather: String? = null
    var weatherDescription: String? = null
    var minMax: String? = null

    companion object {
        @JvmStatic
        fun from(response: WeatherResponse?, context: Context, errorThrown: Boolean): WeatherData {
            val data = WeatherData ()
            data.isErrorThrown = errorThrown;
            if(response != null) {
                data.location = String.format(context.getString(R.string.todays_weather), response.name)
                data.temperature = String.format(context.getString(R.string.todays_weather), response.name)
                data.imageUrl = response.weatherObjList?.get(0)?.icon
                data.mainWeather = response.weatherObjList?.get(0)?.main
                data.weatherDescription = response.weatherObjList?.get(0)?.description
                data.minMax = String.format(context.getString(R.string.minMax), WeatherFunctions.convertKelvinToFahrenheit(response.main!!.tempMin), WeatherFunctions.convertKelvinToFahrenheit(response.main!!.tempMax))
            }
            return data
        }
    }
}