package com.lwo.weather.ui.fragment

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.lwo.weather.core.cloud.Api
import com.lwo.weather.core.cloud.getResult
import com.lwo.weather.data.weather.data.mapToUi
import com.lwo.weather.domain.usecase.FetchWeatherUseCase
import com.lwo.weather.domain.usecase.SearchCitiesUseCase
import com.lwo.weather.ui.fragment.state.ScreenState
import com.lwo.weather.ui.fragment.state.UiEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WeatherViewModel @AssistedInject constructor(
    @Assisted initialState: ScreenState,
    private val fetchWeatherUseCase: FetchWeatherUseCase,
    private val searchCitiesUseCase: SearchCitiesUseCase
) : MavericksViewModel<ScreenState>(initialState) {

    private var searchJob: Job? = null

    init {
        fetchWeatherInCity(null)
    }

    fun processEvent(event: UiEvent) {
        when (event) {
            is UiEvent.Search -> {
                searchCitiesByQuery(event.query.trim())
            }

            is UiEvent.NewCity -> {
                if (event.query.trim().isBlank()) return
                fetchWeatherInCity(event.query)
            }
        }
    }

    private fun searchCitiesByQuery(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(200)
            searchCitiesUseCase.search(Api.API_KEY, query).collect {
                it.getResult(
                    success = {
                        setState { ScreenState(search = it.result) }
                    },
                    failure = {
                        setState { ScreenState(search = emptyList()) }
                    },
                    loading = {

                    })
            }
        }
    }

    private fun fetchWeatherInCity(city: String?) = viewModelScope.launch {
        fetchWeatherUseCase.fetch(Api.API_KEY, city).collect {
            it.getResult(
                success = {
                    setState { ScreenState(data = it.result.mapToUi()) }
                },
                failure = {
                    setState { ScreenState(error = it.exception) }
                },
                loading = {
                    setState { ScreenState(loading = true) }
                }
            )
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<WeatherViewModel, ScreenState> {
        override fun create(state: ScreenState): WeatherViewModel
    }

    companion object : MavericksViewModelFactory<WeatherViewModel, ScreenState> by hiltMavericksViewModelFactory()
}