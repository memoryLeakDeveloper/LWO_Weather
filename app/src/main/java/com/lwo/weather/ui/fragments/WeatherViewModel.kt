package com.lwo.weather.ui.fragments

import com.lwo.weather.domain.usecase.FetchWeatherUseCase
import javax.inject.Inject

class WeatherViewModel @Inject constructor(private val fetchWeatherUseCase: FetchWeatherUseCase) {
}