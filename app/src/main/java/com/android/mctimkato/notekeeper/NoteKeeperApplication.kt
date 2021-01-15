package com.android.mctimkato.notekeeper

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class NoteKeeperApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        setUpNightMode()
    }

    //set night mode as default
    private fun setUpNightMode() {
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        )
    }
}