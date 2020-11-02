package com.example.weatherchallengemvvmkotlin.injection

import android.content.Context
import com.example.weatherchallengemvvmkotlin.data.network.WeatherClient
import com.example.weatherchallengemvvmkotlin.data.network.WeatherNetworkService
import com.example.weatherchallengemvvmkotlin.data.network.WeatherService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule (protected var context: Context) {
    protected var applicationComponent: ApplicationComponent? = null
    @JvmName("setApplicationComponent1")
    fun setApplicationComponent(appComponent: ApplicationComponent) {
        applicationComponent = appComponent
    }

    @Provides
    @Singleton
    fun providesRestClient(): WeatherNetworkService {
        val client = WeatherClient()
        val restClient = client.retrofit?.create(WeatherService::class.java)?.let { WeatherNetworkService(it) }
        applicationComponent!!.inject(restClient)
        return restClient!!
    }
}