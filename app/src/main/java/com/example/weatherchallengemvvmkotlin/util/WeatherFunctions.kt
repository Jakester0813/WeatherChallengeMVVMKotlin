package com.example.weatherchallengemvvmkotlin.util

object WeatherFunctions {
    fun convertKelvinToFahrenheit(kelvin: Double): String {
        return java.lang.Long.toString(Math.round(9 / 5 * (kelvin - 273) + 32))
    }
}