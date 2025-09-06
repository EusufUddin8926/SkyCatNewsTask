// WebViewScreen.kt (in commonMain)
package org.task.skycatnews.features.web_screen.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kevinnzou.compose.webview.WebView
import com.kevinnzou.compose.webview.rememberWebViewState
import com.multiplatform.webview.web.rememberWebViewState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebViewScreen(
    viewModel: WebLinkViewModel,
    url: String,
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(url) {
        if (url.isNotBlank()) {
            viewModel.processUrl(url)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sky Cat News") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                state.error != null -> {
                    Text(
                        text = "Error: ${state.error}",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp)
                    )
                }

                state.url.isNotBlank() -> {
                    val webViewState = rememberWebViewState(url = state.url)

                    WebView(
                        state = webViewState,
                        modifier = Modifier.fillMaxSize(),
                        onCreated = { webView ->
                            // Platform-specific configuration
                            when {
                                // Android configuration
                                Platform.isAndroid() -> {
                                    webView.settings.javaScriptEnabled = true
                                    webView.settings.domStorageEnabled = true
                                    webView.settings.setSupportZoom(true)
                                    webView.settings.builtInZoomControls = true
                                    webView.settings.displayZoomControls = false
                                }
                                // iOS configuration
                                Platform.isIOS() -> {
                                    // iOS-specific configuration if needed
                                }
                            }
                        },
                        onLoading = { loading ->
                            // Handle loading state if needed
                        }
                    )
                }

                else -> {
                    Text(
                        text = "No URL provided",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

// Platform detection utility
object Platform {
    fun isAndroid(): Boolean {
        return System.getProperty("java.vm.name") == "Dalvik" ||
                System.getProperty("java.vm.name") == "ART"
    }

    fun isIOS(): Boolean {
        return !isAndroid()
    }
}