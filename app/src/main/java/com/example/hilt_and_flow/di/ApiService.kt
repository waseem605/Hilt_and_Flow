package com.example.hilt_and_flow.di

import com.example.hilt_and_flow.mvvm.weatherModels.MainWeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("data/2.5/forecast")
    fun getWeatherDetails(
        @Query("lat")ll: String,
        @Query("lon")long: String,
        @Query("appid")appid: String): Call<MainWeatherModel>

}