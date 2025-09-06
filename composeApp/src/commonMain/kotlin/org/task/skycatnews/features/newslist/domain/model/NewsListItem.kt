package org.task.skycatnews.features.newslist.domain.model

data class NewsListItem(
    val id: String,
    val type: String,
    val headline: String,
    val teaserText: String,
    val creationDate: String,
    val modifiedDate: String,
    val imageUrl: String,
    val accessibilityText: String,
    val weblinkUrl: String? = null
) {
    val isStory: Boolean get() = type == "story"
    val isWebLink: Boolean get() = type == "weblink"
    val isAdvert: Boolean get() = type == "advert"
}
