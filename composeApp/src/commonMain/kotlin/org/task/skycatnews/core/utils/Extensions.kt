package org.task.skycatnews.core.utils


import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

fun String.toAnnotatedStringWithBold(): AnnotatedString {
    return buildAnnotatedString {
        val parts = this@toAnnotatedStringWithBold.split("**")
        parts.forEachIndexed { index, part ->
            if (index % 2 == 1) {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(part)
                }
            } else {
                append(part)
            }
        }
    }
}

fun String.truncate(maxLength: Int): String {
    return if (length > maxLength) {
        substring(0, maxLength) + "..."
    } else {
        this
    }
}

fun String.capitalizeFirstLetter(): String {
    return if (isNotEmpty()) {
        this[0].uppercase() + substring(1)
    } else {
        this
    }
}