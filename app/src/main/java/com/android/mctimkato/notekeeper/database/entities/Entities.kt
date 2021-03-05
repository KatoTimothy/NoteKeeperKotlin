package com.android.mctimkato.notekeeper.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Represents a single entry of note in the database
* */
@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val courseId: String,
    val title: String,
    val summary: String
)

/*
* Represents a single entry of course in the database
* */
@Entity(tableName = "course_table")
data class CourseEntity(
    @PrimaryKey
    val id: String,
    val title: String
)