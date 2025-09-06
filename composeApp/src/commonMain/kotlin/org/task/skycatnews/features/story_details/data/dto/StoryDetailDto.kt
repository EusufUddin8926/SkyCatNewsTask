package org.task.skycatnews.features.story_details.data.dto

data class StoryDetailDto(
    val id: String,
    val headline: String,
    val heroImage: HeroImageDto, // Changed from heroImageUrl to heroImage object
    val creationDate: String,
    val modifiedDate: String,
    val contents: List<StoryContentDto>
)

data class HeroImageDto(
    val imageUrl: String,
    val accessibilityText: String
)

sealed class StoryContentDto {
    data class Paragraph(val text: String) : StoryContentDto()
    data class Image(val url: String, val accessibilityText: String) : StoryContentDto()
}

