package org.task.skycatnews.features.newslist.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class NewsListResponseDto(
    val title: String,
    val data: List<NewsItemDto>
)

@Serializable
sealed class NewsItemDto {
    abstract val id: String?
    abstract val type: String
}

@Serializable
data class StoryDto(
    override val id: String,
    override val type: String = "story",
    val headline: String,
    val teaserText: String,
    val creationDate: String,
    val modifiedDate: String,
    val teaserImage: ImageDto
) : NewsItemDto()

@Serializable
data class WebLinkDto(
    override val id: String,
    override val type: String = "weblink",
    val headline: String,
    val weblinkUrl: String,
    val creationDate: String,
    val modifiedDate: String,
    val teaserImage: ImageDto
) : NewsItemDto()

@Serializable
data class AdvertDto(
    override val id: String? = null,
    override val type: String = "advert",
    val url: String
) : NewsItemDto()

@Serializable
data class ImageDto(
    val _links: ImageLinks? = null,
    val accessibilityText: String
) {
    val imageUrl: String get() = _links?.url?.href ?: ""
}

@Serializable
data class ImageLinks(
    val url: ImageUrl
)

@Serializable
data class ImageUrl(
    val href: String,
    val templated: Boolean = false,
    val type: String = "image/jpeg"
)