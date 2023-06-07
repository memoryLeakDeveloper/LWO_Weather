package com.lwo.weather.ui.fragment.state

sealed interface UiEvent {
    class Search(val query: String): UiEvent
    class NewCity(val query: String): UiEvent

}
