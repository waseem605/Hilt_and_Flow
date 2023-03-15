package com.example.hilt_and_flow.di

import android.app.Application
import android.util.Log
import com.example.hilt_and_flow.APP_TAG
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication(): Application() {

    override fun onCreate() {
        super.onCreate()

        Log.d(APP_TAG,"MyApplication         0.0 ")
    }
}