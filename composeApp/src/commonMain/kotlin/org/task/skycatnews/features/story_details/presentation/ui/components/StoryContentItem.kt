package org.task.skycatnews.features.story_details.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.task.skycatnews.features.storydetails.domain.model.StoryContent

@Composable
fun StoryContentItem(content: StoryContent) {
    when (content) {
        is StoryContent.Paragraph -> Text(
            text = content.text,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )

        is StoryContent.Image -> Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.LightGray)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Image Placeholder")
        }
    }
}
