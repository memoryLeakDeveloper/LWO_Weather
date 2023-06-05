package com.lwo.weather.data.weather.data

data class ForecastWeatherDayData(
    val date: String?,
    val dateEpoch: Int,
    val day: WeatherDayData,
    val astro: AstroData,
    val hour: List<HoursData>
)