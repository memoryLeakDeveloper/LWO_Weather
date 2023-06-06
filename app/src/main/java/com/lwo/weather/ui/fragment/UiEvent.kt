package com.lwo.weather.ui.fragment

sealed interface UiEvent {
    class Search(val query: String): UiEvent
}
