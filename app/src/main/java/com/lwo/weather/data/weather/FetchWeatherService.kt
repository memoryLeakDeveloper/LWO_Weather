package com.lwo.weather.data.weather

import com.lwo.weather.core.cloud.Api
import com.lwo.weather.core.cloud.CloudResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface FetchWeatherService {
    @GET("${Api.apiV1}/TODO")
    suspend fun fetchWeather(@Header("Authorization") auth: String): Response<WeatherCloud>
}