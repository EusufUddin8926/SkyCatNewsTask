package org.task.skycatnews.core.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import kotlinx.serialization.Serializable

@Serializable
sealed class Route {
    abstract val route: String

    @Serializable
    data object NewsList : Route() {
        override val route: String = "newsList"
    }

    @Serializable
    data object StoryDetail : Route() {
        override val route: String = "storyDetail/{storyId}"

        fun createRoute(storyId: String) = "storyDetail/$storyId"

        val arguments = listOf(
            navArgument("storyId") {
                type = NavType.StringType
            }
        )
    }

    @Serializable
    data object WebView : Route() {
        override val route: String = "webView/{url}"

        fun createRoute(url: String) = "webView/${url.encodeForRoute()}"

        val arguments = listOf(
            navArgument("url") {
                type = NavType.StringType
            }
        )
    }
}

// Utility functions for route encoding/decoding
fun String.encodeForRoute(): String {
    return this.replace("/", "_slash_")
        .replace("?", "_question_")
        .replace("&", "_ampersand_")
        .replace("=", "_equals_")
        .replace("%", "_percent_")
        .replace("#", "_hash_")
}

fun String.decodeFromRoute(): String {
    return this.replace("_slash_", "/")
        .replace("_question_", "?")
        .replace("_ampersand_", "&")
        .replace("_equals_", "=")
        .replace("_percent_", "%")
        .replace("_hash_", "#")
}

// Helper function to extract story ID from route
fun String.getStoryId(): String? {
    return if (this.startsWith("storyDetail/")) {
        this.removePrefix("storyDetail/").takeIf { it.isNotBlank() }
    } else {
        null
    }
}

// Helper function to extract URL from route
fun String.getUrl(): String? {
    return if (this.startsWith("webView/")) {
        this.removePrefix("webView/").decodeFromRoute().takeIf { it.isNotBlank() }
    } else {
        null
    }
}