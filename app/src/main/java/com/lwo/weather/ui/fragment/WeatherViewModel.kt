package com.lwo.weather.ui.fragment

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.hilt.AssistedViewModelFactory
import com.airbnb.mvrx.hilt.hiltMavericksViewModelFactory
import com.lwo.weather.core.cloud.Api
import com.lwo.weather.core.cloud.getResult
import com.lwo.weather.domain.usecase.FetchWeatherUseCase
import com.lwo.weather.ui.fragment.state.ScreenState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

class WeatherViewModel @AssistedInject constructor(
    @Assisted initialState: ScreenState,
    private val fetchWeatherUseCase: FetchWeatherUseCase
) : MavericksViewModel<ScreenState>(initialState) {

    init {
        viewModelScope.launch {
            fetchWeatherUseCase.fetch(Api.API_KEY, null).collect {
                it.getResult(
                    success = {
                        setState { ScreenState(data = it.result) }
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

    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<WeatherViewModel, ScreenState> {
        override fun create(state: ScreenState): WeatherViewModel
    }

    companion object : MavericksViewModelFactory<WeatherViewModel, ScreenState> by hiltMavericksViewModelFactory()
}