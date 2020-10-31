package com.example.weatherchallengemvvmkotlin.injection;

import android.app.Application;

import com.example.weatherchallengemvvmkotlin.ui.main.MainActivity;
import com.example.weatherchallengemvvmkotlin.ui.main.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent extends CoreComponent {
    void inject(Application obj);

    void inject(MainActivity obj);
    void inject(MainActivityViewModel obj);
}
