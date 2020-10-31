package com.example.weatherchallengemvvmkotlin.network;

import com.example.weatherchallengemvvmkotlin.util.WeatherConstants;

public class WeatherNetworkService {

/*    WeatherAPI mAPIService;

    Subscription subscription;

    public WeatherNetworkService(WeatherAPI apiService){
        this.mAPIService = apiService;
    }

    public void getWeatherDetails(String query, final WeatherListener callback){
        mAPIService.getWeather(query, WeatherConstants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherResponse>() {


                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WeatherResponse weatherResponse) {
                        callback.onResponse(weatherResponse);
                    }
                });
    }

    public void unsubscribe(){
        if(subscription!=null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }*/
}
