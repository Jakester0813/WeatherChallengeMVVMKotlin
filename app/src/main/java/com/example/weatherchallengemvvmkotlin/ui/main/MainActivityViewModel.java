package com.example.weatherchallengemvvmkotlin.ui.main;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherchallengemvvmkotlin.WeatherMVVMKotlinApplication;
import com.example.weatherchallengemvvmkotlin.data.models.WeatherData;
import com.example.weatherchallengemvvmkotlin.data.network.WeatherNetworkService;
import com.example.weatherchallengemvvmkotlin.util.WeatherConstants;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

import static android.content.Context.MODE_PRIVATE;

public class MainActivityViewModel extends AndroidViewModel {

    @Inject
    WeatherNetworkService restClient;

    protected CompositeDisposable disposables = new CompositeDisposable();
    protected MutableLiveData<WeatherData> weatherData = new MutableLiveData<>();

    SharedPreferences mWeatherPrefs;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        WeatherMVVMKotlinApplication.getInstance().getAppComponent().inject(this);
        mWeatherPrefs = application.getSharedPreferences(WeatherConstants.PREFS_NAME, MODE_PRIVATE);
        if (mWeatherPrefs.contains((WeatherConstants.LOCATION_DATA)))
            getLocationData(mWeatherPrefs.getString(WeatherConstants.LOCATION_DATA, ""));
    }

    public void retrieveWeather(String location) {
        mWeatherPrefs.edit().putString(WeatherConstants.LOCATION_DATA, location).apply();
        getLocationData(location);
    }

    private void getLocationData(String query) {
        disposables.add(restClient.getWeatherDetails(query,
                weatherResponse -> {
                    weatherData.postValue(WeatherData.from(weatherResponse, getApplication(), true));
                },
                throwable -> {
                    weatherData.postValue(WeatherData.from(null, getApplication(), true));
                }));

    }

    public MutableLiveData<WeatherData> getWeatherData() {
        return weatherData;
    }

    public boolean isInputAZipCode(String input) {
        return isParsableAsInt(input) && input.length() == 5;
    }

    public boolean isInputACity(String input) {
        return input.matches("[ a-zA-Z]+");
    }

    private boolean isParsableAsInt(String input) {
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.dispose();
    }
}
