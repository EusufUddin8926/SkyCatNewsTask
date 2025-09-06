package org.task.skycatnews.features.storydetails.domain.model

data class StoryDetail(
    val id: String,
    val headline: String,
    val heroImageUrl: String?,
    val accessibilityText: String,
    val creationDate: String,
    val modifiedDate: String,
    val contents: List<StoryContent>
)

sealed class StoryContent {
    data class Paragraph(val text: String) : StoryContent()
    data class Image(val url: String, val accessibilityText: String) : StoryContent()
}
