package org.task.skycatnews.features.newslist.domain.repository

import org.task.skycatnews.features.newslist.domain.model.NewsListItem


interface NewsListRepository {
    suspend fun getNewsList(): List<NewsListItem>
}