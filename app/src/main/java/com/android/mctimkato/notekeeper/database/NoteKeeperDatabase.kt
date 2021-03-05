package com.android.mctimkato.notekeeper.database

import android.content.Context

abstract class NoteKeeperDatabase {

    companion object {

        @Volatile
        var INSTANCE: NoteKeeperDatabase? = null

        fun getInstance(context: Context): NoteKeeperDatabase? {

            val instance = INSTANCE

            return null

        }
    }
}