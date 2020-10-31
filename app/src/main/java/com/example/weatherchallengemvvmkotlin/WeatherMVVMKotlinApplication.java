package com.example.weatherchallengemvvmkotlin;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.weatherchallengemvvmkotlin.injection.ApplicationComponent;
import com.example.weatherchallengemvvmkotlin.injection.ApplicationModule;
import com.example.weatherchallengemvvmkotlin.injection.ComponentObject;
import com.example.weatherchallengemvvmkotlin.injection.DaggerApplicationComponent;

import timber.log.Timber;


public class WeatherMVVMKotlinApplication extends Application implements Application.ActivityLifecycleCallbacks, ComponentObject<ApplicationComponent> {

    private static WeatherMVVMKotlinApplication instance;
    private ApplicationComponent applicationComponent;

    public static WeatherMVVMKotlinApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Timber.plant(new Timber.DebugTree());
        registerActivityLifecycleCallbacks(this);
        ApplicationModule appModule = new ApplicationModule(this);
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(appModule).build();
        appModule.setActivityComponent(applicationComponent);
        getAppComponent().inject(this);
    }

    public ApplicationComponent getAppComponent() {
        return applicationComponent;
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }

    @Override
    public ApplicationComponent getComponent() {
        return null;
    }
}
