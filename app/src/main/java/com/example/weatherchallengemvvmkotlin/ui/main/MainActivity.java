package com.example.weatherchallengemvvmkotlin.ui.main;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.weatherchallengemvvmkotlin.BR;
import com.example.weatherchallengemvvmkotlin.R;
import com.example.weatherchallengemvvmkotlin.WeatherMVVMKotlinApplication;
import com.example.weatherchallengemvvmkotlin.databinding.MainActivityBinding;
import com.facebook.drawee.backends.pipeline.Fresco;

/*
  In a more ideal situation, given that the app complexity would expand where Fragments are needed, there would be some sort
  of UI container to hold at least 1 fragment where we can set up View Models there. But since there is no need for
 */

public class MainActivity extends AppCompatActivity {

    MainActivityBinding binding;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherMVVMKotlinApplication.getInstance().getAppComponent().inject(this);
        Fresco.initialize(this);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.executePendingBindings();
        binding.weatherEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    String input = textView.getText().toString();
                    //restricts input down to zip code or city to handle a lot of user input cases
                    if (viewModel.isInputACity(input) || viewModel.isInputAZipCode(input))
                        viewModel.retrieveWeather(textView.getText().toString());
                    return true;
                }
                return false;
            }
        });

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getWeatherData().observe(this, weatherData -> {
            binding.setVariable(BR.failed, weatherData.isErrorThrown());
            if (!weatherData.isErrorThrown()) {
                binding.location.setText(weatherData.getLocation());
                binding.temperature.setText(weatherData.getTemperature());
                binding.weatherImg.setImageURI(weatherData.getImageUrl());
                binding.mainWeather.setText(weatherData.getMainWeather());
                binding.description.setText(weatherData.getWeatherDescription());
                binding.minMax.setText(weatherData.getMinMaxString());
            }
        });
    }
}