package org.task.skycatnews.features.web_screen.di

import org.koin.dsl.module
import org.task.skycatnews.features.web_screen.viewmodel.WebLinkViewModel

val webLinkModule = module {
    factory { WebLinkViewModel() }
}