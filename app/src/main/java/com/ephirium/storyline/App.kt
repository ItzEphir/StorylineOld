package com.ephirium.storyline

import android.app.Application

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        defaultTag = "Storyline"
        info(message = "Application Loaded", clazz = this.javaClass)
    }
}