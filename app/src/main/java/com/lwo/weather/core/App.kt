package com.lwo.weather.core

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.airbnb.mvrx.navigation.DefaultNavigationViewModelDelegateFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this, viewModelDelegateFactory = DefaultNavigationViewModelDelegateFactory())
    }
}