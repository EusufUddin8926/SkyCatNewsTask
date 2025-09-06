package org.task.skycatnews.features.story_details.domain.usecase

import org.task.skycatnews.features.story_details.domain.repository.StoryDetailRepository
import org.task.skycatnews.features.storydetails.domain.model.StoryDetail

class GetStoryDetailUseCase(
    private val repository: StoryDetailRepository
) {
    operator fun invoke(storyId: String): StoryDetail {
        return repository.getStoryDetailById(storyId)
    }
}
