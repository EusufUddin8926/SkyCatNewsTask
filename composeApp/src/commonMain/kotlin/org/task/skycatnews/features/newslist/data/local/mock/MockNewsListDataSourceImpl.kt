package org.task.skycatnews.features.newslist.data.local.mock

import org.task.skycatnews.features.newslist.data.dto.AdvertDto
import org.task.skycatnews.features.newslist.data.dto.ImageDto
import org.task.skycatnews.features.newslist.data.dto.ImageLinks
import org.task.skycatnews.features.newslist.data.dto.ImageUrl
import org.task.skycatnews.features.newslist.data.dto.NewsListResponseDto
import org.task.skycatnews.features.newslist.data.dto.StoryDto
import org.task.skycatnews.features.newslist.data.dto.WebLinkDto


class MockNewsListDataSourceImpl : MockNewsListDataSource {
    override suspend fun getMockNewsList(): NewsListResponseDto {
        return NewsListResponseDto(
            title = "Sky Cat News",
            data = listOf(
                StoryDto(
                    id = "1",
                    headline = "Story Headline 1",
                    teaserText = "Teaser text - max lines 3\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
                    creationDate = "2020-11-18T00:00:00Z",
                    modifiedDate = "2020-11-19T00:00:00Z",
                    teaserImage = ImageDto(
                        _links = ImageLinks(ImageUrl("")),
                        accessibilityText = "Image content description"
                    )
                ),
                StoryDto(
                    id = "2",
                    headline = "Story Headline",
                    teaserText = "max lines 2 - Lorem ipsum dolor sit amet, consectetur adipiscing",
                    creationDate = "2020-11-18T01:00:00Z",
                    modifiedDate = "2020-11-19T01:00:00Z",
                    teaserImage = ImageDto(
                        _links = ImageLinks(ImageUrl("")),
                        accessibilityText = "Image content description"
                    )
                ),
                AdvertDto(url = "advert/url"),
                WebLinkDto(
                    id = "3",
                    headline = "Weblink Headline",
                    weblinkUrl = "https://example.com",
                    creationDate = "2020-11-18T02:00:00Z",
                    modifiedDate = "2020-11-19T02:00:00Z",
                    teaserImage = ImageDto(
                        _links = ImageLinks(ImageUrl("")),
                        accessibilityText = "Image content description"
                    )
                ),
                StoryDto(
                    id = "4",
                    headline = "Story headline",
                    teaserText = "max lines 2 - Lorem ipsum dolor sit amet, consectetur adipiscing",
                    creationDate = "2020-11-17T00:00:00Z",
                    modifiedDate = "2020-11-18T00:00:00Z",
                    teaserImage = ImageDto(
                        _links = ImageLinks(ImageUrl("")),
                        accessibilityText = "Image content description"
                    )
                )
            )
        )
    }
}