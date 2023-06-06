package com.lwo.weather.data.search

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.domain.repository.SearchCitiesRepository
import com.lwo.weather.domain.usecase.SearchCitiesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchCitiesUseCaseImpl @Inject constructor(private val repository: SearchCitiesRepository) : SearchCitiesUseCase {

    override suspend fun search(token: String, query: String) = flow {
        emit(CloudResponse.Loading())
        emit(repository.search(token, query))
    }.catch {
        emit(CloudResponse.Error(it))
    }
}