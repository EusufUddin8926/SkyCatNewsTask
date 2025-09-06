package org.task.skycatnews.features.story_details.data.repositories


import StoryDetailMockData
import org.task.skycatnews.features.story_details.data.mappers.toDomain
import org.task.skycatnews.features.story_details.domain.repository.StoryDetailRepository
import org.task.skycatnews.features.storydetails.domain.model.StoryDetail

class StoryDetailRepositoryImpl : StoryDetailRepository {
    override fun getStoryDetailById(storyId: String): StoryDetail {
        return StoryDetailMockData.mockStoryDto.toDomain()
    }
}
