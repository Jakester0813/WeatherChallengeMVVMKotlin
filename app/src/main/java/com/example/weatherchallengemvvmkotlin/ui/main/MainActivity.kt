package com.example.weatherchallengemvvmkotlin.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherchallengemvvmkotlin.BR
import com.example.weatherchallengemvvmkotlin.R
import com.example.weatherchallengemvvmkotlin.WeatherMVVMKotlinApplication
import com.example.weatherchallengemvvmkotlin.data.models.WeatherData
import com.example.weatherchallengemvvmkotlin.databinding.MainActivityBinding
import com.facebook.drawee.backends.pipeline.Fresco

class MainActivity: AppCompatActivity() {
    var binding: MainActivityBinding? = null
    var viewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        WeatherMVVMKotlinApplication.instance.appComponent?.inject(this)
        Fresco.initialize(this)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding?.weatherEdit?.setOnEditorActionListener(TextView.OnEditorActionListener { textView, actionId, keyEvent ->
            val viewModel = this.viewModel
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val input = textView.text.toString()
                //restricts input down to zip code or city to handle a lot of user input cases
                if (viewModel?.isInputACity(input)!! || viewModel?.isInputAZipCode(input)!!) viewModel?.retrieveWeather(textView.text.toString())
                return@OnEditorActionListener true
            }
            false
        })

        viewModel?.weatherData?.observe(this, Observer { weatherData: WeatherData ->
            val binding = this.binding
            binding?.setVariable(BR.failed, weatherData.isErrorThrown)
            if (!weatherData.isErrorThrown) {
                binding?.location?.text = weatherData.location
                binding?.temperature?.text = weatherData.temperature
                binding?.weatherImg?.setImageURI(weatherData.imageUrl)
                binding?.mainWeather?.text = weatherData.mainWeather
                binding?.description?.text = weatherData.weatherDescription
                binding?.minMax?.setText(weatherData.minMax)
            }
        })
    }
}