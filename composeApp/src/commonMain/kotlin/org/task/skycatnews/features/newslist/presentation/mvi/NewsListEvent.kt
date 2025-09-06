package org.task.skycatnews.features.newslist.presentation.mvi

sealed class NewsListEvent {
    object LoadNews : NewsListEvent()
    data class RefreshNews(val force: Boolean = false) : NewsListEvent()
}
