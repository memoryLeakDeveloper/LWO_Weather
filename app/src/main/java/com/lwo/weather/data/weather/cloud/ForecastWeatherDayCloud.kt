package com.lwo.weather.data.weather.cloud

import com.google.gson.annotations.SerializedName
import com.lwo.weather.data.weather.data.ForecastWeatherDayData

data class ForecastWeatherDayCloud(
    @SerializedName("date") val date: String?,
    @SerializedName("date_epoch") val dateEpoch: Int,
    @SerializedName("day") val day: WeatherDayCloud,
    @SerializedName("astro") val astro: AstroCloud,
    @SerializedName("hour") val hour: List<HoursCloud>
)

fun ForecastWeatherDayCloud.mapToData() = ForecastWeatherDayData(
    date = date,
    dateEpoch = dateEpoch,
    day = day.mapToData(),
    astro = astro.mapToData(),
    hour = hour.map { it.mapToData() }
)