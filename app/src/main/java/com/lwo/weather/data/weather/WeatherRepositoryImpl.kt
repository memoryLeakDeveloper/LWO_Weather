package com.lwo.weather.data.weather

import com.lwo.weather.domain.repository.WeatherRepository
import com.lwo.weather.domain.source.FetchWeatherDataSource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val fetchWeatherDataSource: FetchWeatherDataSource) : WeatherRepository {

    override suspend fun fetchWeather(token: String, town: String?) = fetchWeatherDataSource.fetch(token, town)

}