package com.lwo.weather.domain.usecase

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.weather.data.CurrentWeatherComposeData
import kotlinx.coroutines.flow.Flow

interface FetchWeatherUseCase {

    suspend fun fetch(token: String, city: String?): Flow<CloudResponse<CurrentWeatherComposeData>>
}