package com.lwo.weather.domain.usecase

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.data.search.SearchData
import io.reactivex.Observable

interface SearchCitiesUseCase {

    fun search(token: String, query: String): Observable<CloudResponse<List<SearchData>>>

}