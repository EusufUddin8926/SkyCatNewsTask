package org.task.skycatnews.core.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime

object DateUtils {

    fun formatRelativeTime(dateString: String): String {
        return try {
            val instant = Instant.parse(dateString)
            val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
            val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

            val difference = now.date - localDateTime.date

            when {
                difference.days == 0 -> "Today"
                difference.days == 1 -> "Yesterday"
                difference.days < 7 -> "${difference.days}d ago"
                difference.days < 30 -> "${difference.days / 7}w ago"
                else -> "${difference.days / 30}mo ago"
            }
        } catch (e: Exception) {
            "Unknown time"
        }
    }

    fun parseDate(dateString: String): Instant? {
        return try {
            Instant.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }
}