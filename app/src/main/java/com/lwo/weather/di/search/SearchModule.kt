package com.lwo.weather.di.search

import com.airbnb.mvrx.hilt.MavericksViewModelComponent
import com.lwo.weather.core.cloud.Api
import com.lwo.weather.data.search.SearchCitiesDataSourceImpl
import com.lwo.weather.data.search.SearchCitiesRepositoryImpl
import com.lwo.weather.data.search.SearchCitiesService
import com.lwo.weather.data.search.SearchCitiesUseCaseImpl
import com.lwo.weather.domain.repository.SearchCitiesRepository
import com.lwo.weather.domain.source.SearchCitiesDataSource
import com.lwo.weather.domain.usecase.SearchCitiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@Module
@InstallIn(MavericksViewModelComponent::class)
class SearchModule {

    @Provides
    fun provideSearchRepository(searchCitiesDataSource: SearchCitiesDataSource): SearchCitiesRepository =
        SearchCitiesRepositoryImpl(searchCitiesDataSource)

    @Provides
    fun provideSearchCitiesDataSource(api: Api): SearchCitiesDataSource = SearchCitiesDataSourceImpl(
        api.makeService(SearchCitiesService::class.java),
    )

    @Provides
    fun provideSearchCitiesUseCase(repository: SearchCitiesRepository): SearchCitiesUseCase = SearchCitiesUseCaseImpl(repository)
}