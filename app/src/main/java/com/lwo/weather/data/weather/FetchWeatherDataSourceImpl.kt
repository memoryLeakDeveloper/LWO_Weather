package com.lwo.weather.data.weather

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.domain.source.FetchWeatherDataSource
import javax.inject.Inject

class FetchWeatherDataSourceImpl @Inject constructor(private val service: FetchWeatherService) : FetchWeatherDataSource {

    override suspend fun fetch(token: String): CloudResponse<WeatherData> {
        val response = service.fetchWeather(token)
        return if (response.isSuccessful)
            response.body()?.let { CloudResponse.Success(it.mapToData()) } ?: run { CloudResponse.Error(Exception()) }
        else
            CloudResponse.Error(Exception(response.errorBody()?.string()))
    }

}