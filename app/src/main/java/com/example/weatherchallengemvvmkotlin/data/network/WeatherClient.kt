package com.example.weatherchallengemvvmkotlin.data.network

import com.example.weatherchallengemvvmkotlin.util.WeatherConstants
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class WeatherClient @Inject constructor(): OkHttpClient() {
    private val service: WeatherNetworkService? = null
    val retrofit: Retrofit?
        get() = WeatherClient.Companion.retrofit

    companion object {
        private var retrofit: Retrofit? = null
    }

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient().newBuilder().addInterceptor(interceptor).build()
        WeatherClient.Companion.retrofit = Retrofit.Builder()
                .baseUrl(WeatherConstants.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
    }
}