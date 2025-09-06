package org.task.skycatnews.core.di


import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.task.skycatnews.features.newslist.di.newsListModule
import org.task.skycatnews.features.story_details.di.storyDetailModule

expect val initTargetModule: Module

fun initKoin(enableNetworkLogs: Boolean = true, config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            initTargetModule,
            newsListModule,
            storyDetailModule
        )
    }
}