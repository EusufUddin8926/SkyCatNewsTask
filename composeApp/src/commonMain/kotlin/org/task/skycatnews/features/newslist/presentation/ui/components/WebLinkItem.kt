package org.task.skycatnews.features.newslist.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.task.skycatnews.core.components.formatNewsDate
import org.task.skycatnews.features.newslist.domain.model.NewsListItem

@Composable
fun WebLinkItem(
    newsItem: NewsListItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        // Gray box placeholder (same as StoryItem)
        Box(
            modifier = Modifier
                .size(44.dp)
                .background(color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))
                .clip(RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            // You could add a different icon or indicator for weblinks if needed
        }

        Column(modifier = Modifier.weight(1f).padding(start = 12.dp)) {
            Text(
                text = newsItem.headline,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                maxLines = 2
            )

            Text(
                text = newsItem.weblinkUrl!!,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                modifier = Modifier.padding(top = 4.dp),
                color = MaterialTheme.colorScheme.onSurface
            )

            HorizontalDivider(
                Modifier.padding(vertical = 12.dp),
                DividerDefaults.Thickness, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
            )
        }

        Text(
            text = formatNewsDate(newsItem.creationDate),
            style = MaterialTheme.typography.labelSmall.copy(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
            ),
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.Top)
        )
    }
}