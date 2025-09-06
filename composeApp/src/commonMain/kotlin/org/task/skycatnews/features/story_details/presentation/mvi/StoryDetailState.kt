package org.task.skycatnews.features.story_details.presentation.mvi

import org.task.skycatnews.features.storydetails.domain.model.StoryDetail

sealed class StoryDetailState {
    object Loading : StoryDetailState()
    data class Success(val story: StoryDetail) : StoryDetailState()
    data class Error(val message: String) : StoryDetailState()
}
