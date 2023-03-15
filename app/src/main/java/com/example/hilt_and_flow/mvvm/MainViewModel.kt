package com.example.hilt_and_flow.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hilt_and_flow.apiWeatherKey
import com.example.hilt_and_flow.models.HomeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    var mWeatherData = repository.weatherList


    fun callData(
        lat: String,
        lng: String
    ) {
        repository.getWeather(lat, lng, apiWeatherKey)
    }


}