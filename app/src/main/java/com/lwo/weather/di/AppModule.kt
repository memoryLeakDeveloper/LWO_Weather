package com.lwo.weather.di

import com.lwo.weather.core.cloud.Api
import com.lwo.weather.core.cloud.ApiLocal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi(): Api = Api()

    @Provides
    fun provideApiLocal(): ApiLocal = ApiLocal()
}