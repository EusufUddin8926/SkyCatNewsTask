package org.task.skycatnews.features.web_screen.presentation

data class WebLinkState(
    val url: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)
