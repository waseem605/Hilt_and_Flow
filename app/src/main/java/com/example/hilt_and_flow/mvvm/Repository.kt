package com.example.hilt_and_flow.mvvm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.hilt_and_flow.di.ApiService
import com.example.hilt_and_flow.mvvm.weatherModels.MainWeatherModel
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class Repository @Inject constructor(
   @Named("RetrofitServiceWeather") val apiService: ApiService
) {

    val weatherList = MutableLiveData<MainWeatherModel>()

    fun getWeather(
        lat: String,
        lng: String,
        appId: String
    ){
        apiService.getWeatherDetails(lat,lng,appId).enqueue(object :retrofit2.Callback<MainWeatherModel>{
            override fun onResponse(
                call: Call<MainWeatherModel>,
                response: Response<MainWeatherModel>
            ) {
                if (response.isSuccessful){
                    weatherList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<MainWeatherModel>, t: Throwable) {

            }

        })

    }
}