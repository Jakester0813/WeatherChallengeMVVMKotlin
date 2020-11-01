package com.example.weatherchallengemvvmkotlin.injection;

import android.content.Context;

import com.example.weatherchallengemvvmkotlin.data.network.WeatherClient;
import com.example.weatherchallengemvvmkotlin.data.network.WeatherNetworkService;
import com.example.weatherchallengemvvmkotlin.data.network.WeatherService;

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
    public WeatherNetworkService providesRestClient() {
        WeatherClient client = new WeatherClient();
        WeatherNetworkService restClient = new WeatherNetworkService(client.getRetrofit().create(WeatherService.class));
        activityComponent.inject(restClient);
        return restClient;
    }
}
