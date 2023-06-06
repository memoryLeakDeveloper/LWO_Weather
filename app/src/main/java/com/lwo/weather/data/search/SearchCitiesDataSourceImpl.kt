package com.lwo.weather.data.search

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.domain.source.SearchCitiesDataSource
import javax.inject.Inject

class SearchCitiesDataSourceImpl @Inject constructor(private val service: SearchCitiesService) : SearchCitiesDataSource {

    override suspend fun search(token: String, query: String): CloudResponse<List<SearchData>> {
        val response = service.searchCities(token, query)
        return if (response.isSuccessful) {
            response.body()?.let { CloudResponse.Success(it.map { it.mapToData() }) } ?: run { CloudResponse.Error(Exception()) }
        } else {
            CloudResponse.Error(Exception(response.errorBody()?.string()))
        }
    }

}