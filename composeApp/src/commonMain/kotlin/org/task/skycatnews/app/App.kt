package org.task.skycatnews.app

import androidx.compose.runtime.*
import org.task.skycatnews.core.navigation.AppNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.task.skycatnews.core.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        AppNavigation()
    }
}