package com.lwo.weather.domain.repository

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.search.SearchData

interface SearchCitiesRepository {

    fun search(token: String, query: String): CloudResponse<List<SearchData>>

}