package com.ephirium.storyline.app

import android.app.Application
import com.ephirium.storyline.*

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        defaultTag = getString(R.string.app_name)
        infoTag = getString(R.string.app_name)
        warningTag = getString(R.string.app_name) + "Warning"
        errorTag = getString(R.string.app_name) + "Error"
        this info "Application successfully loaded"
    }
}