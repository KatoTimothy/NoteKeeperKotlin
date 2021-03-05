package com.android.mctimkato.notekeeper.database.dao

import androidx.room.*
import com.android.mctimkato.notekeeper.database.entities.CourseEntity
import com.android.mctimkato.notekeeper.database.entities.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    //fetches notes sorted sorted by title
    @Query("SELECT * FROM note_table ORDER BY title")
    fun getAll(): List<NoteEntity>

    //fetches note given its id
    @Query("SELECT * FROM note_table WHERE id = :id")
    fun get(id: Long): Flow<NoteEntity>

    //Inserts note. Ignores insert if given note is identical to one in the table
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: NoteEntity): Long

    //updates given course
    @Update
    suspend fun update(note: NoteEntity)

    //deletes all notes given in the list
    @Delete
    suspend fun deleteAll(notes: List<NoteEntity>)
}

@Dao
interface CoursesDao {
    //adds given course to courses table
    @Insert
    suspend fun add(course: CourseEntity)

    //adds a given list of courses in the table
    @Insert
    suspend fun addAll(courses: List<CourseEntity>)

    //fetches all courses ordered by id
    @Query("SELECT * FROM course_table")
    fun getAll(): List<CourseEntity>

    //fetches particular course given its id
    @Query("SELECT * FROM course_table WHERE id = :id")
    fun get(id: String): Flow<CourseEntity>

    //Deletes all given list items from course_table
    @Delete
    suspend fun deleteAll(courses: List<CourseEntity>)
}