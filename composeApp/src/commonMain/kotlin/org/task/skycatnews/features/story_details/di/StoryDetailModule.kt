package org.task.skycatnews.features.story_details.di


import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.task.skycatnews.features.story_details.data.repositories.StoryDetailRepositoryImpl
import org.task.skycatnews.features.story_details.domain.repository.StoryDetailRepository
import org.task.skycatnews.features.story_details.domain.usecase.GetStoryDetailUseCase
import org.task.skycatnews.features.story_details.presentation.mvi.StoryDetailViewModel

val storyDetailModule = module {

    single<StoryDetailRepository> { StoryDetailRepositoryImpl() }

    factory { GetStoryDetailUseCase(get()) }

    viewModel { (storyId: String) ->
        StoryDetailViewModel(
            storyId = storyId,
            getStoryDetailUseCase = get()
        )
    }
}
