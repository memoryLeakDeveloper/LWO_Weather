package com.lwo.weather.data.weather

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.domain.repository.WeatherRepository
import com.lwo.weather.domain.usecase.FetchWeatherUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchWeatherUseCaseImpl @Inject constructor(private val repository: WeatherRepository) : FetchWeatherUseCase {

    override fun fetch(token: String) = flow {
        emit(CloudResponse.Loading())
        emit(repository.fetchWeather(token))
    }.catch {
        emit(CloudResponse.Error(it))
    }

}