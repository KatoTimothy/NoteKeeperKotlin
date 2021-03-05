package com.android.mctimkato.notekeeper.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.mctimkato.notekeeper.room.entities.Course
import com.android.mctimkato.notekeeper.room.entities.Note

@Database(entities = [Note::class, Course::class], version = 1, exportSchema = false)
abstract class NotekeeperDatabase : RoomDatabase() {
    companion object {
        @Volatile
        var INSTANCE: NotekeeperDatabase? = null

        fun getInstance(context: Context): NotekeeperDatabase {

            synchronized(this) {
                var instance = Room.databaseBuilder(
                    context,
                    NotekeeperDatabase::class.java,
                    "notekeeper_db"
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance

                return instance
            }
        }
    }
}