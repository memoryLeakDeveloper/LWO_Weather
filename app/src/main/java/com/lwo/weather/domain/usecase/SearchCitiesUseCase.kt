package com.lwo.weather.domain.usecase

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.search.SearchData
import kotlinx.coroutines.flow.Flow

interface SearchCitiesUseCase {

    suspend fun search(token: String, query: String): Flow<CloudResponse<List<SearchData>>>

}