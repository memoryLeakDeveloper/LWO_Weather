package com.lwo.weather.domain.source

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.search.SearchData

interface SearchCitiesDataSource {

    suspend fun search(token: String, query: String): CloudResponse<List<SearchData>>

}