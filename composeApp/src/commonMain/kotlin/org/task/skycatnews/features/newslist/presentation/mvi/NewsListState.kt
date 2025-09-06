package org.task.skycatnews.features.newslist.presentation.mvi

import org.task.skycatnews.features.newslist.domain.model.NewsListItem


sealed class NewsListState {
    object Loading : NewsListState()
    data class Success(val newsItems: List<NewsListItem>) : NewsListState()
    data class Error(val message: String) : NewsListState()
}
