package org.task.skycatnews.features.newslist.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.task.skycatnews.core.components.formatNewsDate
import org.task.skycatnews.features.newslist.domain.model.NewsListItem

@Composable
fun FeaturedStoryItem(
    newsItem: NewsListItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        // Image placeholder (replace with AsyncImage later)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Image Placeholder",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = newsItem.headline,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            modifier = modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = newsItem.teaserText,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 3,
            modifier = modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = formatNewsDate(newsItem.creationDate),
            style = MaterialTheme.typography.labelSmall.copy(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
            ),
            modifier = modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}
