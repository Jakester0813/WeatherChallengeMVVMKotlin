package com.example.weatherchallengemvvmkotlin.data.models;

import android.content.Context;

import com.example.weatherchallengemvvmkotlin.R;
import com.example.weatherchallengemvvmkotlin.util.WeatherFunctions;

public class WeatherData {
    boolean errorThrown;
    String location;
    String temperature;
    String imageUrl;
    String mainWeather;
    String weatherDescription;
    String minMaxString;

    public static WeatherData from(WeatherResponse response, Context context, boolean errorThrown) {
        WeatherData data = new WeatherData();
        data.errorThrown = errorThrown;
        if (response != null) {
            data.location = String.format(context.getString(R.string.todays_weather), response.getName());
            data.temperature = String.format(context.getString(R.string.temperature), WeatherFunctions.convertKelvinToFahrenheit(response.getMain().getTemp()));
            data.imageUrl = response.getWeatherObjects().get(0).getIcon();
            data.mainWeather = response.getWeatherObjects().get(0).getMain();
            data.weatherDescription = response.getWeatherObjects().get(0).getDescription();
            data.minMaxString = String.format(context.getString(R.string.minMax), WeatherFunctions.convertKelvinToFahrenheit(response.getMain().getTempMin()), WeatherFunctions.convertKelvinToFahrenheit(response.getMain().getTempMax()));
        }
        return data;
    }

    public boolean isErrorThrown() {
        return errorThrown;
    }

    public String getLocation() {
        return location;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getMainWeather() {
        return mainWeather;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getMinMaxString() {
        return minMaxString;
    }
}
