package com.example.daggerhiltretrofit.di

import android.app.ApplicationExitInfo
import com.example.daggerhiltretrofit.network.PostApiService
import com.example.daggerhiltretrofit.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule  {


    @Provides
    @Singleton
    fun provideRetrofitBuilder() : Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providesPostApiService(retrofit: Retrofit) : PostApiService =
        retrofit.create(PostApiService::class.java)
}