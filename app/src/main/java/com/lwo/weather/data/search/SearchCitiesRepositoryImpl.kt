package com.lwo.weather.data.search

import com.lwo.weather.domain.repository.SearchCitiesRepository
import com.lwo.weather.domain.source.SearchCitiesDataSource
import javax.inject.Inject

class SearchCitiesRepositoryImpl @Inject constructor(private val searchCitiesDataSource: SearchCitiesDataSource) : SearchCitiesRepository {

    override suspend fun search(token: String, query: String) = searchCitiesDataSource.search(token, query)

}