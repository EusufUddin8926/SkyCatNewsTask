package org.task.skycatnews.features.story_details.data.mappers

import org.task.skycatnews.features.story_details.data.dto.StoryContentDto
import org.task.skycatnews.features.story_details.data.dto.StoryDetailDto
import org.task.skycatnews.features.storydetails.domain.model.*

// Mapper extension functions
fun StoryDetailDto.toDomain(): StoryDetail {
    return StoryDetail(
        id = this.id,
        headline = this.headline,
        heroImageUrl = this.heroImage.imageUrl,
        accessibilityText = this.heroImage.accessibilityText,
        creationDate = this.creationDate,
        modifiedDate = this.modifiedDate,
        contents = this.contents.map { it.toDomain() }
    )
}

fun StoryContentDto.toDomain(): StoryContent {
    return when (this) {
        is StoryContentDto.Paragraph -> StoryContent.Paragraph(this.text)
        is StoryContentDto.Image -> StoryContent.Image(this.url, this.accessibilityText)
    }
}
