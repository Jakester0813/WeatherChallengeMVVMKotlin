package com.example.weatherchallengemvvmkotlin.network;

import com.example.weatherchallengemvvmkotlin.util.WeatherConstants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient extends OkHttpClient{
    private static Retrofit retrofit = null;
    private WeatherNetworkService service;

//    public static AsyncActionListener listener;

    public WeatherClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(WeatherConstants.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        service = retrofit.create(WeatherNetworkService.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public WeatherNetworkService getZeeMeeService() {
        return service;
    }

/*    public <T> Disposable makeRequest(Single<T> request, final Consumer<T> onSuccess, final Consumer<Throwable> onError) {
        return request.subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> { if (listener != null) listener.startAsyncAction(); })
                .doFinally(() -> { if (listener != null) listener.endAsyncAction(); })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onSuccess, onError);
    }*/
}
