package org.task.skycatnews.features.newslist.data.repository

import org.task.skycatnews.features.newslist.data.dto.NewsListResponseDto
import org.task.skycatnews.features.newslist.data.local.mock.MockNewsListDataSource
import org.task.skycatnews.features.newslist.data.mapper.toDomain
import org.task.skycatnews.features.newslist.domain.model.NewsListItem
import org.task.skycatnews.features.newslist.domain.repository.NewsListRepository


class NewsListRepositoryImpl(
    private val mockDataSource: MockNewsListDataSource
) : NewsListRepository {

    override suspend fun getNewsList(): List<NewsListItem> {
        val response = mockDataSource.getMockNewsList()
        return response.data.mapNotNull { it.toDomain() }
    }
}