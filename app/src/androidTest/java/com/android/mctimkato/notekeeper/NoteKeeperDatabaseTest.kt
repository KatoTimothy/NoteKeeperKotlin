package com.android.mctimkato.notekeeper

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.mctimkato.notekeeper.room.NotekeeperDatabase
import com.android.mctimkato.notekeeper.room.dao.CoursesDao
import com.android.mctimkato.notekeeper.room.dao.NotesDao
import com.android.mctimkato.notekeeper.room.entities.Note
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class NoteKeeperDatabaseTest {

    private lateinit var notesDao: NotesDao
    private lateinit var coursesDao: CoursesDao

    private lateinit var database: NotekeeperDatabase

    @Before
    fun createDatabase() {
        //get application context
        val context = ApplicationProvider.getApplicationContext<Context>()

        //create an in memory database
        database = Room.inMemoryDatabaseBuilder(context, NotekeeperDatabase::class.java).build()

        notesDao = database.notesDao
        coursesDao = database.courseDao

    }

    @After
    @Throws(IOException::class)
    fun closeDatabase() {
        database.close()
    }

    @Test
    @Throws(Exception::class)
    suspend fun addNoteAndGetNoteFromList() {
        val note = Note(1, "android_test", "Unit Testing", "It is really important to do unit test")
        val note2 = Note(
            2,
            "kotlin_coroutines",
            "Kotlin Coroutines",
            "They enable handling asynchronous tasks"
        )

        val rowsAffected = notesDao.putVarying(note, note2)

    }
}