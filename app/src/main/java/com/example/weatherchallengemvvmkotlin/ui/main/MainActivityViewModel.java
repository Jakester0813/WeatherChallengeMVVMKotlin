package com.example.weatherchallengemvvmkotlin.ui.main;

import com.example.weatherchallengemvvmkotlin.network.WeatherClient;

import javax.inject.Inject;

public class MainActivityViewModel {

    @Inject WeatherClient restClient;
    public MainActivityViewModel() {
//        getAppComponent().inject(this);
    }
}
