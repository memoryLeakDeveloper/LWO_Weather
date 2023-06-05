package com.lwo.weather.domain.usecase

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.weather.WeatherData
import kotlinx.coroutines.flow.Flow

interface FetchWeatherUseCase {

    fun fetch(token: String): Flow<CloudResponse<WeatherData>>
}