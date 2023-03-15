package com.example.hilt_and_flow.di

import android.app.Application
import com.example.hilt_and_flow.models.CountryModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.io.IOException
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CountryModule {

    @Singleton
    @Provides
    @Named("country_json_data")
    fun getCountryJason(app:Application):ArrayList<CountryModel>{
        val mList=ArrayList<CountryModel>()
        lateinit var jsonString: String
        try {
            jsonString = app.assets.open("country_name_currency.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {

        }

        val listCountryType = object : TypeToken<List<CountryModel>>() {}.type
        return Gson().fromJson(jsonString, listCountryType)
    }
}