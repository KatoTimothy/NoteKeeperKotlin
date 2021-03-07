package com.android.mctimkato.notekeeper

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.mctimkato.notekeeper.room.NotekeeperDatabase
import com.android.mctimkato.notekeeper.room.dao.CoursesDao
import com.android.mctimkato.notekeeper.room.dao.NotesDao
import com.android.mctimkato.notekeeper.room.entities.Note
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class NoteKeeperDatabaseTest {

    private lateinit var notesDao: NotesDao
    private lateinit var coursesDao: CoursesDao

    private lateinit var database: NotekeeperDatabase

    private val firstNote = Note(
        1, "android_test",
        "Unit Testing",
        "It is really important to do unit test"
    )
    private val secondNote = Note(
        2,
        "kotlin_coroutines",
        "Kotlin Coroutines",
        "They enable handling asynchronous tasks"
    )

    @Before
    fun createDatabase() {
        //get application context
        val context = ApplicationProvider.getApplicationContext<Context>()

        //create an in memory database
        database = Room.inMemoryDatabaseBuilder(context, NotekeeperDatabase::class.java)
            .build()

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
    fun insertingOneNoteReturnsThatSingleNote() {

        runBlocking {

            notesDao.put(firstNote)
            val testNote = notesDao.getNoteWithId(1)

            testNote.collect {
//                assertEquals(it, firstNote)
//                assertEquals(firstNote.courseId, it.courseId)
                assertEquals(it.courseId, firstNote.courseId)
            }
        }

    }

    @Test
    @Throws(Exception::class)
    fun insertingVariableListofTwoNotesRetrieveTwoNotesBack() {

        runBlocking {

            notesDao.insertVariableListofNotes(firstNote, secondNote)

            notesDao.getAllNotes().collect { noteList ->

                assertEquals(noteList.size, 2)
            }

        }
    }
}