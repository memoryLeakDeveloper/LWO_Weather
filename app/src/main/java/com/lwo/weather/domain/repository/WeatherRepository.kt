package com.lwo.weather.domain.repository

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.weather.data.CurrentWeatherComposeData

interface WeatherRepository {

    suspend fun fetchWeather(token: String, city: String?): CloudResponse<CurrentWeatherComposeData>
}