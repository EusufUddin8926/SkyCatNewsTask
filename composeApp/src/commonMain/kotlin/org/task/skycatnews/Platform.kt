package org.task.skycatnews

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform