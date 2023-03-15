package com.example.hilt_and_flow.mvvm.weatherModels

import com.google.gson.annotations.SerializedName
import com.example.hilt_and_flow.mvvm.weatherModels.*

data class WeatherList(
    @SerializedName("dt"         ) var dt         : Int?               = null,
    @SerializedName("main"       ) var main       : Main?              = Main(),
    @SerializedName("weather"    ) var weather    : ArrayList<Weather> = arrayListOf(),
    @SerializedName("clouds"     ) var clouds     : Clouds?            = Clouds(),
    @SerializedName("wind"       ) var wind       : Wind?              = Wind(),
    @SerializedName("visibility" ) var visibility : Int?               = null,
    @SerializedName("pop"        ) var pop        : Double?            = null,
    @SerializedName("sys"        ) var sys        : Sys?               = Sys(),
    @SerializedName("dt_txt"     ) var dtTxt      : String?            = null
)
