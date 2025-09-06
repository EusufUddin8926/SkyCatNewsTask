// WebLinkViewModel.kt (in commonMain)
package org.task.skycatnews.features.web_screen.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WebLinkViewModel {
    private val _state = MutableStateFlow(WebLinkState())
    val state: StateFlow<WebLinkState> = _state.asStateFlow()

    fun processUrl(url: String) {
        _state.value = WebLinkState(isLoading = true)

        // Validate and process URL
        val processedUrl = if (url.startsWith("http://") || url.startsWith("https://")) {
            url
        } else {
            "https://$url"
        }

        _state.value = WebLinkState(url = processedUrl, isLoading = false)
    }
}

data class WebLinkState(
    val url: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)