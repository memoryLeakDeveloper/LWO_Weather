package com.lwo.weather.domain.source

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.weather.WeatherData

interface FetchWeatherDataSource {

    suspend fun fetch(token: String): CloudResponse<WeatherData>
}