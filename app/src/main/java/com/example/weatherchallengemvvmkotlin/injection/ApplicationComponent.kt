package com.example.weatherchallengemvvmkotlin.injection

import com.example.weatherchallengemvvmkotlin.WeatherMVVMKotlinApplication
import com.example.weatherchallengemvvmkotlin.data.network.WeatherNetworkService
import com.example.weatherchallengemvvmkotlin.ui.main.MainActivity
import com.example.weatherchallengemvvmkotlin.ui.main.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : CoreComponent {
    fun inject(obj: WeatherMVVMKotlinApplication?)
    fun inject(obj: MainActivity?)
    fun inject(obj: MainActivityViewModel?)
    fun inject(obj: WeatherNetworkService?)
}