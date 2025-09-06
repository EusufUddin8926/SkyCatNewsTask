package org.task.skycatnews.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf
import org.task.skycatnews.features.newslist.presentation.mvi.NewsListViewModel
import org.task.skycatnews.features.newslist.presentation.ui.screen.NewsListScreen
import org.task.skycatnews.features.story_details.presentation.mvi.StoryDetailViewModel
import org.task.skycatnews.features.story_details.presentation.ui.screen.StoryDetailScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.NewsList.route
    ) {

        composable(
            route = Route.NewsList.route
        ) {
            val viewModel = koinViewModel<NewsListViewModel>()
            NewsListScreen(
                viewModel = viewModel,
                onStoryClick = { storyId ->
                    navController.navigate(Route.StoryDetail.createRoute(storyId))
                },
                onWebLinkClick = { url ->
                    navController.navigate(Route.WebView.createRoute(url))
                }
            )
        }

        composable(
            route = Route.StoryDetail.route,
            arguments = Route.StoryDetail.arguments
        ) { backStackEntry ->
            val storyId = backStackEntry.arguments?.getString("storyId") ?: ""
            val viewModel = koinViewModel<StoryDetailViewModel>(
                parameters = { parametersOf(storyId) }
            )

            StoryDetailScreen(
                viewModel = viewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

       /* composable(
            route = Route.WebView.route,
            arguments = Route.WebView.arguments
        ) { backStackEntry ->
            val encodedUrl = backStackEntry.arguments?.getString("url") ?: ""
            val url = encodedUrl.decodeFromRoute()

            WebViewScreen(
                url = url,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }*/
    }
}