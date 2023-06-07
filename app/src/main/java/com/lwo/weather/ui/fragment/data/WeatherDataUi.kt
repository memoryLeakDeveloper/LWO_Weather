package com.lwo.weather.ui.fragment.data

data class WeatherDataUi(
    val isDay: Boolean,
    val city: String,
    val temp: Float?,
    val wind: Float?,
    val humidity: Int?,
    val condition: String,
    val conditionIcon: String?,
    val forecast: List<ForecastDataUi>?
)