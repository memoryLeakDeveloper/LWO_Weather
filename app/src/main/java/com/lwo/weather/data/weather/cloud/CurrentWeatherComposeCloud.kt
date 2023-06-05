package com.lwo.weather.data.weather.cloud

import com.google.gson.annotations.SerializedName
import com.lwo.weather.data.weather.data.CurrentWeatherComposeData

data class CurrentWeatherComposeCloud(
    @SerializedName("current") val current: WeatherCloud?,
    @SerializedName("forecast") val forecast: ForecastWeatherCloud?,
    @SerializedName("location") val location: LocationCloud?
)

fun CurrentWeatherComposeCloud.mapToData() = CurrentWeatherComposeData(
    current = current?.mapToData(),
    forecast = forecast?.mapToData(),
    location = location?.mapToData()
)