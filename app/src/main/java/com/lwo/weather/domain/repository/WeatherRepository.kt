package com.lwo.weather.domain.repository

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.weather.WeatherData

interface WeatherRepository {

    suspend fun fetchWeather(token: String): CloudResponse<WeatherData>
}