package org.task.skycatnews.features.newslist.presentation.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.task.skycatnews.core.components.ErrorView
import org.task.skycatnews.core.components.LoadingIndicator
import org.task.skycatnews.features.newslist.presentation.mvi.NewsListEvent
import org.task.skycatnews.features.newslist.presentation.mvi.NewsListState
import org.task.skycatnews.features.newslist.presentation.mvi.NewsListViewModel
import org.task.skycatnews.features.newslist.presentation.ui.components.AdvertItem
import org.task.skycatnews.features.newslist.presentation.ui.components.FeaturedStoryItem
import org.task.skycatnews.features.newslist.presentation.ui.components.StoryItem
import org.task.skycatnews.features.newslist.presentation.ui.components.WebLinkItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(
    viewModel: NewsListViewModel,
    onStoryClick: (String) -> Unit,
    onWebLinkClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val state = viewModel.state

    // Trigger loading once when screen starts
    LaunchedEffect(Unit) {
        viewModel.onEvent(NewsListEvent.LoadNews)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(
                            text = "Sky Cat News",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (val currentState = state) {
                NewsListState.Loading -> LoadingIndicator()

                is NewsListState.Success -> {
                    val items = currentState.newsItems
                    if (items.isNotEmpty()) {
                        val featuredItem = items.first()
                        val otherItems = items.drop(1)

                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            item {
                                FeaturedStoryItem(
                                    newsItem = featuredItem,
                                    onClick = { onStoryClick(featuredItem.id) }
                                )
                            }


                            items(otherItems) { item ->
                                when {
                                    item.isStory -> {
                                        StoryItem(
                                            newsItem = item,
                                            onClick = { onStoryClick(item.id) }
                                        )
                                    }
                                    item.isWebLink -> {
                                        WebLinkItem(
                                            newsItem = item,
                                            onClick = { item.weblinkUrl?.let(onWebLinkClick) }
                                        )
                                    }
                                    item.isAdvert -> {
                                        AdvertItem(newsItem = item)
                                    }
                                }
                            }
                        }
                    }
                }


                is NewsListState.Error -> {
                    ErrorView(
                        message = currentState.message,
                        onRetry = { viewModel.onEvent(NewsListEvent.LoadNews) }
                    )
                }
            }
        }
    }
}
