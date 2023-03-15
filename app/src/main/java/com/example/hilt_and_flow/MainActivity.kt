package com.example.hilt_and_flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.hilt_and_flow.models.CountryModel
import com.example.hilt_and_flow.models.HomeModel
import com.example.hilt_and_flow.mvvm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val model: MainViewModel by viewModels()

    @Inject
    @Named("Home_list")
    lateinit var mList:ArrayList<HomeModel>

    @Inject
    @Named("country_json_data")
    lateinit var mCountryList:ArrayList<CountryModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



            model.callData("33.6844", "73.0479")


        model.mWeatherData.observe(this, Observer {
            Log.d(APP_TAG, "Observer    $it      ")
        })

        Log.d(APP_TAG,"MainActivity         0 ")
        Log.d(APP_TAG,"MainActivity    $mList      1")
        Log.d(APP_TAG,"mCountryList    $mCountryList     ")
    }
}