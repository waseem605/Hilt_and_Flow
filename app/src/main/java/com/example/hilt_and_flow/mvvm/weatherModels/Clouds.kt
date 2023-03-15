package com.example.hilt_and_flow.mvvm.weatherModels

import com.google.gson.annotations.SerializedName

data class Clouds(  @SerializedName("all" ) var all : Int? = null
)
