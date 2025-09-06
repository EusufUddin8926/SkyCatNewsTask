package org.task.skycatnews.features.story_details.presentation.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.task.skycatnews.features.story_details.domain.usecase.GetStoryDetailUseCase

class StoryDetailViewModel(
    private val storyId: String,
    private val getStoryDetailUseCase: GetStoryDetailUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<StoryDetailState>(StoryDetailState.Loading)
    val state: StateFlow<StoryDetailState> = _state

    init {
        loadStoryDetail()
    }

    private fun loadStoryDetail() {
        viewModelScope.launch {
            try {
                delay(200)
                val story = getStoryDetailUseCase(storyId)
                _state.value = StoryDetailState.Success(story)
            } catch (e: Exception) {
                _state.value = StoryDetailState.Error("Failed to load story")
            }
        }

    }
}
