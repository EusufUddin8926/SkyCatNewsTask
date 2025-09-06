// WebLinkViewModel.kt (in commonMain)
package org.task.skycatnews.features.web_screen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.task.skycatnews.features.web_screen.state.WebLinkState

class WebLinkViewModel() : ViewModel() {
    private val _state = MutableStateFlow(WebLinkState())
    val state: StateFlow<WebLinkState> = _state.asStateFlow()

    fun processUrl(url: String) {
        viewModelScope.launch {
            _state.value = WebLinkState(isLoading = true)
            delay(200)

            // Validate and process URL
            val processedUrl = if (url.startsWith("http://") || url.startsWith("https://")) {
                url
            } else {
                "https://$url"
            }

            _state.value = WebLinkState(url = processedUrl, isLoading = false)
        }
    }
}