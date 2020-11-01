package com.example.weatherchallengemvvmkotlin.injection;

import com.example.weatherchallengemvvmkotlin.WeatherMVVMKotlinApplication;
import com.example.weatherchallengemvvmkotlin.data.network.WeatherNetworkService;
import com.example.weatherchallengemvvmkotlin.ui.main.MainActivity;
import com.example.weatherchallengemvvmkotlin.ui.main.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent extends CoreComponent {
    void inject(WeatherMVVMKotlinApplication obj);

    void inject(MainActivity obj);

    void inject(MainActivityViewModel obj);

    void inject(WeatherNetworkService obj);
}
