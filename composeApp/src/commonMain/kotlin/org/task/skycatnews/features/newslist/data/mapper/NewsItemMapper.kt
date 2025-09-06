package org.task.skycatnews.features.newslist.data.mapper

import org.task.skycatnews.features.newslist.data.dto.AdvertDto
import org.task.skycatnews.features.newslist.data.dto.NewsItemDto
import org.task.skycatnews.features.newslist.data.dto.StoryDto
import org.task.skycatnews.features.newslist.data.dto.WebLinkDto
import org.task.skycatnews.features.newslist.domain.model.NewsListItem


fun StoryDto.toDomain(): NewsListItem {
    return NewsListItem(
        id = id,
        type = type,
        headline = headline,
        teaserText = teaserText,
        creationDate = creationDate,
        modifiedDate = modifiedDate,
        imageUrl = teaserImage.imageUrl,
        accessibilityText = teaserImage.accessibilityText
    )
}

fun WebLinkDto.toDomain(): NewsListItem {
    return NewsListItem(
        id = id,
        type = type,
        headline = headline,
        teaserText = headline,
        creationDate = creationDate,
        modifiedDate = modifiedDate,
        imageUrl = teaserImage.imageUrl,
        accessibilityText = teaserImage.accessibilityText,
        weblinkUrl = weblinkUrl
    )
}

fun AdvertDto.toDomain(): NewsListItem? {
    // Adverts might not be displayed in the list or handled differently
    return null
}

fun NewsItemDto.toDomain(): NewsListItem? {
    return when (this) {
        is StoryDto -> this.toDomain()
        is WebLinkDto -> this.toDomain()
        is AdvertDto -> this.toDomain()
        else -> null
    }
}