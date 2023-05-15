package com.ephirium.storyline.app

import android.app.Application
import com.ephirium.storyline.R
import com.ephirium.common.log.*


class App : Application() {
    override fun onCreate() {
        super.onCreate()

        defaultTag = getString(R.string.app_name)
        infoTag = getString(R.string.app_name)
        warningTag = getString(R.string.app_name) + "Warning"
        errorTag = getString(R.string.app_name) + "Error"
        info("Application successfully loaded")
    }
}