package com.lwo.weather.data.weather

import com.lwo.weather.core.cloud.Api
import com.lwo.weather.data.weather.cloud.CurrentWeatherComposeCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FetchWeatherService {
    @GET("${Api.apiV1}/forecast.json")
    suspend fun fetchWeather(
        @Query("key") auth: String,
        @Query("q") town: String = "Minsk",
        @Query("days") days: Int = 3
    ): Response<CurrentWeatherComposeCloud>
}