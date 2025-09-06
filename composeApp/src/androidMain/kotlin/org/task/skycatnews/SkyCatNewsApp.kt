package org.task.skycatnews

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.task.skycatnews.core.di.initKoin

class SkyCatNewsApp : Application()  {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@SkyCatNewsApp)
        }
    }
}