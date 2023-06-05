package com.lwo.weather.domain.source

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.weather.data.CurrentWeatherComposeData

interface FetchWeatherDataSource {

    suspend fun fetch(token: String, town: String?): CloudResponse<CurrentWeatherComposeData>
}