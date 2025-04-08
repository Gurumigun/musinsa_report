package com.kiy.musinsa.app

import android.app.Application
import com.airbnb.mvrx.Mavericks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MusinsaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Mavericks.initialize(context = this)
    }
}