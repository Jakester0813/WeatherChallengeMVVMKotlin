package com.example.weatherchallengemvvmkotlin.injection;

import android.content.Context;

import com.example.weatherchallengemvvmkotlin.network.WeatherClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    protected ApplicationComponent activityComponent;
    protected Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    public void setActivityComponent(ApplicationComponent component) {
        activityComponent = component;
    }

    @Provides
    @Singleton
    public WeatherClient providesRestClient() {
        WeatherClient restClient = new WeatherClient();
//        activityComponent.inject(restClient);
        return restClient;
    }
}
