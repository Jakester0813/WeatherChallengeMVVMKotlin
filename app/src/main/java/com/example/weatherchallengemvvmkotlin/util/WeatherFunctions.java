package com.example.weatherchallengemvvmkotlin.util;

public class WeatherFunctions {
    public static String convertKelvinToFahrenheit(Double kelvin) {
        return Long.toString(Math.round((9 / 5) * (kelvin - 273) + 32));
    }
}
