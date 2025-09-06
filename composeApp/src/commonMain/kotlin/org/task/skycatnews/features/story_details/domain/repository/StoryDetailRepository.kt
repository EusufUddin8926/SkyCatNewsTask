package org.task.skycatnews.features.story_details.domain.repository

import org.task.skycatnews.features.storydetails.domain.model.StoryDetail

interface StoryDetailRepository {
    fun getStoryDetailById(storyId: String): StoryDetail
}
