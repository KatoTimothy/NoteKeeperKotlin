package com.android.mctimkato.notekeeper.database.dao

import com.android.mctimkato.notekeeper.database.entities.CourseEntity
import com.android.mctimkato.notekeeper.database.entities.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NotesDao {
    //fetches notes sorted by title
    fun getAll(): List<NoteEntity>

    //fetches particular note
    fun get(id: Long): Flow<NoteEntity>

    //Inserts note
    suspend fun insert(note: NoteEntity): Long
}

interface CoursesDao {
    //fetches all courses
    fun getAll(): List<CourseEntity>

    //fetches particular course given its id
    fun get(id: String): Flow<CourseEntity>
}