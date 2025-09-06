package org.task.skycatnews.features.newslist.domain.usecase

import org.task.skycatnews.features.newslist.domain.repository.NewsListRepository


class GetNewsListUseCase(
    private val repository: NewsListRepository
) {
    suspend operator fun invoke() = repository.getNewsList()
}