package org.task.skycatnews.features.newslist.data.local.mock

import org.task.skycatnews.features.newslist.data.dto.NewsListResponseDto


interface MockNewsListDataSource {
    suspend fun getMockNewsList(): NewsListResponseDto
}