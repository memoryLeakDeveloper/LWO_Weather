package com.lwo.weather.data.weather

import com.lwo.weather.data.weather.cloud.CurrentWeatherComposeCloud
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface FetchWeatherService {
    @GET("/weather")
    suspend fun fetchWeather(
        @Header("Bearer-Authorization") token: String,
        @Query("q") town: String = "Minsk",
        @Query("days") days: Int = 3
    ): Response<CurrentWeatherComposeCloud>
}