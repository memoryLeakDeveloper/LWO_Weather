package com.lwo.weather.ui.fragment.epoxy

import com.airbnb.epoxy.EpoxyController
import com.lwo.weather.data.search.SearchData

class CitiesController(private val list: List<SearchData>, private val callback: (String) -> Unit) : EpoxyController() {

    override fun buildModels() {
        var i: Long = 0
        list.forEach { location ->
            CitiesModel_().apply {
                callback = this@CitiesController.callback
            }
                .id(i++)
                .text(location.name.plus("-").plus(location.country))
                .addTo(this)
        }
    }

}