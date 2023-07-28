package com.lwo.weather.data.weather

import com.lwo.weather.core.App
import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.weather.cloud.mapToData
import com.lwo.weather.data.weather.data.CurrentWeatherComposeData
import com.lwo.weather.domain.source.FetchWeatherDataSource
import com.lwo.weather.utils.bugger
import javax.inject.Inject

class FetchWeatherDataSourceImpl @Inject constructor(private val service: FetchWeatherService) : FetchWeatherDataSource {

    override suspend fun fetch(token: String, city: String?): CloudResponse<CurrentWeatherComposeData> {
        val response = service.fetchWeather(App.token, city ?: run { "Minsk" })
        return if (response.isSuccessful) {
            response.body()?.let { CloudResponse.Success(it.mapToData()) } ?: run { CloudResponse.Error(Exception()) }
        } else {
            CloudResponse.Error(Exception(response.errorBody()?.string()))
        }
    }

}