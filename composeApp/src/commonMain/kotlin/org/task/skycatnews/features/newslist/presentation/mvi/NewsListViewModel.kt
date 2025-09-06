package org.task.skycatnews.features.newslist.presentation.mvi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.task.skycatnews.features.newslist.domain.usecase.GetNewsListUseCase

class NewsListViewModel(
    private val getNewsListUseCase: GetNewsListUseCase
) : ViewModel(){
    var state by mutableStateOf<NewsListState>(NewsListState.Loading)
        private set

    private val coroutineScope = CoroutineScope(Dispatchers.Default)

    fun onEvent(event: NewsListEvent) {
        when (event) {
            NewsListEvent.LoadNews -> loadNews()
            is NewsListEvent.RefreshNews -> refreshNews(event.force)
        }
    }

    private fun loadNews() {
        coroutineScope.launch {
            state = NewsListState.Loading
            delay(400)
            try {
                val newsItems = getNewsListUseCase()
                state = NewsListState.Success(newsItems)
            } catch (e: Exception) {
                state = NewsListState.Error(e.message ?: "Failed to load news")
            }
        }
    }

    private fun refreshNews(force: Boolean) {
        coroutineScope.launch {
            try {
                val newsItems = getNewsListUseCase()
                state = NewsListState.Success(newsItems)
            } catch (e: Exception) {
                // Keep the existing data if refresh fails
                if (state is NewsListState.Success && !force) {
                    // Don't show error if we have cached data
                    return@launch
                }
                state = NewsListState.Error(e.message ?: "Failed to refresh news")
            }
        }
    }
}