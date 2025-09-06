package org.task.skycatnews.features.newslist.di


import org.koin.dsl.module
import org.task.skycatnews.features.newslist.data.local.mock.MockNewsListDataSource
import org.task.skycatnews.features.newslist.data.local.mock.MockNewsListDataSourceImpl
import org.task.skycatnews.features.newslist.data.repository.NewsListRepositoryImpl
import org.task.skycatnews.features.newslist.domain.repository.NewsListRepository
import org.task.skycatnews.features.newslist.domain.usecase.GetNewsListUseCase
import org.task.skycatnews.features.newslist.presentation.mvi.NewsListViewModel

val newsListModule = module {
    single<MockNewsListDataSource> { MockNewsListDataSourceImpl() }
    single<NewsListRepository> { NewsListRepositoryImpl(get()) }
    factory { GetNewsListUseCase(get()) }
    factory { NewsListViewModel(get()) }
}