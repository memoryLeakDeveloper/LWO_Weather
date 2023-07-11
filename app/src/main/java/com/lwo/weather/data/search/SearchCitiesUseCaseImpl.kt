package com.lwo.weather.data.search

import com.lwo.weather.core.cloud.CloudResponse
import com.lwo.weather.domain.repository.SearchCitiesRepository
import com.lwo.weather.domain.usecase.SearchCitiesUseCase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchCitiesUseCaseImpl @Inject constructor(private val repository: SearchCitiesRepository) : SearchCitiesUseCase {

    override fun search(token: String, query: String): Observable<CloudResponse<List<SearchData>>> =
        Observable.create<CloudResponse<List<SearchData>>> { emitter ->
            emitter.onNext(CloudResponse.Loading())
            runCatching {
                emitter.onNext(repository.search(token, query))
            }.getOrElse {
                emitter.onNext(CloudResponse.Error(it))
            }
        }.delay(300L, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .onErrorReturn { CloudResponse.Error(it) }
}