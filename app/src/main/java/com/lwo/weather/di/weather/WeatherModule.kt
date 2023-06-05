package com.lwo.weather.di.weather

import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.lwo.weather.core.cloud.Api
import com.lwo.weather.data.weather.FetchWeatherDataSourceImpl
import com.lwo.weather.data.weather.FetchWeatherService
import com.lwo.weather.data.weather.FetchWeatherUseCaseImpl
import com.lwo.weather.data.weather.WeatherRepositoryImpl
import com.lwo.weather.domain.repository.WeatherRepository
import com.lwo.weather.domain.source.FetchWeatherDataSource
import com.lwo.weather.domain.usecase.FetchWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(MavericksViewModelComponent::class)
class WeatherModule {

    @Provides
    fun provideWeatherRepository(fetchWeatherDataSource: FetchWeatherDataSource): WeatherRepository =
        WeatherRepositoryImpl(fetchWeatherDataSource)

    @Provides
    fun provideFetchWeatherDataSource(api: Api): FetchWeatherDataSource = FetchWeatherDataSourceImpl(
        api.makeService(FetchWeatherService::class.java),
    )

    @Provides
    fun provideFetchWeatherUseCase(repository: WeatherRepository): FetchWeatherUseCase = FetchWeatherUseCaseImpl(repository)

}