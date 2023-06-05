package com.lwo.weather.data.weather.data

data class CurrentWeatherComposeData(
    val current: WeatherData?,
    val forecast: ForecastWeatherData?,
    val location: LocationData?
)