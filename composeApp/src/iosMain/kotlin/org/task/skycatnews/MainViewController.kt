package org.task.skycatnews

import androidx.compose.ui.window.ComposeUIViewController
import org.task.skycatnews.app.App
import org.task.skycatnews.core.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) {

    App()

}