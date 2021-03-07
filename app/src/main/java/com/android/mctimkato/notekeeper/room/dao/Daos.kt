package com.android.mctimkato.notekeeper.room.dao

import androidx.room.*
import com.android.mctimkato.notekeeper.room.entities.Course
import com.android.mctimkato.notekeeper.room.entities.ExpandedNote
import com.android.mctimkato.notekeeper.room.entities.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    //fetches notes sorted sorted by title
    @Query("SELECT * FROM note_table ORDER BY title")
    fun getAllNotes(): Flow<List<Note>>

    //fetches note given its id
    @Query("SELECT * FROM note_table WHERE id = :id")
    fun getNoteWithId(id: Long): Flow<Note>

    //Inserts note. Ignores insert if given note is identical to one in the table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun put(note: Note): Long

    //Inserts note. Ignores insert if given note is identical to one in the table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun putAll(notes: List<Note>)

    //Inserts note. Ignores insert if given note is identical to one in the table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVariableListofNotes(vararg notes: Note)

    //updates given course
    @Update
    suspend fun update(note: Note)

    //deletes all notes given in the list
    @Query("DELETE FROM note_table")
    suspend fun deleteAll()

    @Query(
        "SELECT note_table.id As id , course_table.title as courseTitle,  note_table.summary AS summary  " +
                "FROM  note_table LEFT JOIN course_table ON note_table.courseId = course_table.id"
    )
    fun getExpandedNote(): Flow<List<ExpandedNote>>
}

@Dao
interface CoursesDao {
    //adds given course to courses table
    @Insert
    suspend fun add(course: Course)

    //adds a given list of courses in the table
    @Insert
    suspend fun addAll(courses: List<Course>)

    //fetches all courses ordered by id
    @Query("SELECT * FROM course_table")
    fun getAll(): List<Course>

    //fetches particular course given its id
    @Query("SELECT * FROM course_table WHERE id = :id")
    fun get(id: String): Flow<Course>

    //Deletes all given list items from course_table
    @Query("DELETE FROM note_table")
    suspend fun deleteAll()
}