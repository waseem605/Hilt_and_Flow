package com.example.hilt_and_flow.di

import android.util.Log
import com.example.hilt_and_flow.APP_TAG
import com.example.hilt_and_flow.models.HomeModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ModuleApp {

    @Singleton
    @Provides
    @Named("Home_list")
    fun getHomeList():ArrayList<HomeModel>{
        Log.d(APP_TAG,"ModuleApp          22")
        val mList = ArrayList<HomeModel>()

            Log.d(APP_TAG, "ModuleApp          112")

            Log.d(APP_TAG, "ModuleApp          113")
            mList.add(HomeModel("home", 0))
            mList.add(HomeModel("feature", 0))
            mList.add(HomeModel("scanner", 0))
            mList.add(HomeModel("setting", 0))

        Log.d(APP_TAG,"ModuleApp          31")
        return mList
    }



    @Singleton
    @Provides
    @Named("okHttpClient1")
    fun provideHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    @Named("okHttpClient2")
    fun provideHttpClient2(@Named("okHttpClient1")okHttpClient: OkHttpClient.Builder, httpLoggingInterceptor: HttpLoggingInterceptor,): OkHttpClient.Builder {
        return okHttpClient.addInterceptor(httpLoggingInterceptor)
    }


    @Singleton
    @Provides
    @Named("WeatherBaseURL")
    fun provideRetrofit(
        @Named("okHttpClient2") okHttpClient: OkHttpClient.Builder,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .client(okHttpClient.build())
            .addConverterFactory(gsonConverterFactory)
            .build()
    }
    @Singleton
    @Provides
    @Named("RetrofitServiceWeather")
    fun provideFaceWeatherService(@Named("WeatherBaseURL") retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

}