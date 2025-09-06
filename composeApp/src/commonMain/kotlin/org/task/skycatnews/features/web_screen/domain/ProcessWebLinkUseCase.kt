package org.task.skycatnews.features.web_screen.domain

class ProcessWebLinkUseCase {
    operator fun invoke(url: String): String {
        // Add any URL validation or processing logic here
        return if (url.startsWith("http://") || url.startsWith("https://")) {
            url
        } else {
            "https://$url" // Add https prefix if missing
        }
    }
}