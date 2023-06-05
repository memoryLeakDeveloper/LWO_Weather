package com.lwo.weather.data.weather.cloud

import com.google.gson.annotations.SerializedName
import com.lwo.weather.data.weather.data.ForecastWeatherData

data class ForecastWeatherCloud(@SerializedName("forecastday") val forecast: List<ForecastWeatherDayCloud>)

fun ForecastWeatherCloud.mapToData() = ForecastWeatherData(
    forecast = forecast.map { it.mapToData() }
)