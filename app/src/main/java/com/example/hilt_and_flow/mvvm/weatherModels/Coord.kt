package com.example.hilt_and_flow.mvvm.weatherModels

import com.google.gson.annotations.SerializedName

data class Coord(
    @SerializedName("lat" ) var lat : Double? = null,
    @SerializedName("lon" ) var lon : Double? = null)
