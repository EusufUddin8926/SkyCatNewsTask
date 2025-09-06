package org.task.skycatnews.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ImagePlaceholder(
    modifier: Modifier = Modifier,
    accessibilityText: String = "Image placeholder",
    size: ImagePlaceholderSize = ImagePlaceholderSize.Medium,
    icon: ImageVector = Icons.Default.Image
) {
    val height = when (size) {
        ImagePlaceholderSize.Small -> 80.dp
        ImagePlaceholderSize.Medium -> 200.dp
        ImagePlaceholderSize.Large -> 300.dp
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = accessibilityText,
            modifier = Modifier.size(48.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

enum class ImagePlaceholderSize {
    Small, Medium, Large
}

@Composable
fun CircularImagePlaceholder(
    modifier: Modifier = Modifier,
    accessibilityText: String = "Circular image placeholder",
    size: Int = 48
) {
    Box(
        modifier = modifier
            .size(size.dp)
            .clip(RoundedCornerShape(50))
            .background(MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Image,
            contentDescription = accessibilityText,
            modifier = Modifier.size((size / 2).dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}