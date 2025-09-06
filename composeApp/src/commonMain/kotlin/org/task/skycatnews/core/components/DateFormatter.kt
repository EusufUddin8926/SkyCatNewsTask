package org.task.skycatnews.core.components

import androidx.compose.runtime.Composable
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.task.skycatnews.core.utils.DateUtils

@Composable
fun formatNewsDate(dateString: String): String {
    return DateUtils.formatRelativeTime(dateString)
}

fun formatDateTime(instant: Instant): String {
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
    return "${localDateTime.date} ${localDateTime.time}"
}

fun formatTimeAgo(instant: Instant): String {
    val now = Clock.System.now()
    val duration = now - instant

    return when {
        duration.inWholeSeconds < 60 -> "${duration.inWholeSeconds}s ago"
        duration.inWholeMinutes < 60 -> "${duration.inWholeMinutes}m ago"
        duration.inWholeHours < 24 -> "${duration.inWholeHours}h ago"
        duration.inWholeDays < 7 -> "${duration.inWholeDays}d ago"
        duration.inWholeDays < 30 -> "${duration.inWholeDays / 7}w ago"
        else -> "${duration.inWholeDays / 30}mo ago"
    }
}