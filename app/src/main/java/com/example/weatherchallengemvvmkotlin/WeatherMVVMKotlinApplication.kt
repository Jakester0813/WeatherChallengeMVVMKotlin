package com.example.weatherchallengemvvmkotlin

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.weatherchallengemvvmkotlin.injection.ApplicationComponent
import com.example.weatherchallengemvvmkotlin.injection.ApplicationModule
import com.example.weatherchallengemvvmkotlin.injection.ComponentObject
import timber.log.Timber

class WeatherMVVMKotlinApplication: Application(), Application.ActivityLifecycleCallbacks, ComponentObject<ApplicationComponent?> {
    var appComponent: ApplicationComponent? = null
    private set

    companion object {
        lateinit var instance: WeatherMVVMKotlinApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())
        registerActivityLifecycleCallbacks(this)
        val appModule = ApplicationModule(this)
        appComponent = DaggerApplicationComponent.builder().applicationModule(appModule).build()
        appComponent?.inject(this)
        appModule.setApplicationComponent(appComponent!!)
    }

    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {}
    override fun onActivityStarted(activity: Activity) {}
    override fun onActivityResumed(activity: Activity) {}
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStopped(activity: Activity) {}
    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {}
    override fun onActivityDestroyed(activity: Activity) {}
    override val component: ApplicationComponent?
        get() = null
}