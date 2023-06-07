package com.lwo.weather.data.weather.data

import com.lwo.weather.ui.fragment.data.ForecastDataUi
import com.lwo.weather.ui.fragment.data.WeatherDataUi

data class CurrentWeatherComposeData(
    val current: WeatherData?,
    val forecast: ForecastWeatherData?,
    val location: LocationData?
)

fun CurrentWeatherComposeData.mapToUi() = WeatherDataUi(
    current?.isDay == 1,
    location?.name ?: "No data",
    current?.tempC,
    current?.windKph,
    current?.humidity,
    current?.conditionData?.text ?: "No data",
    current?.conditionData?.getConditionIcon(),
    forecast?.forecast?.map {
        ForecastDataUi(
            it.day.condition?.getConditionIcon(),
            it.day.mintempC.toString().plus("/").plus(it.day.maxtempC)
        )
    })