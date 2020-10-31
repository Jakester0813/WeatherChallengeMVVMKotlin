package com.example.weatherchallengemvvmkotlin.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.weatherchallengemvvmkotlin.R;
import com.example.weatherchallengemvvmkotlin.WeatherMVVMKotlinApplication;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherMVVMKotlinApplication.getInstance().getAppComponent().inject(this);
        //binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
    }
}