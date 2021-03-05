package com.android.mctimkato.notekeeper.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* Represents a single entry of note in the database
* */
@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val courseId: String,
    val title: String?,
    val summary: String?
)

/*
* Represents a single entry of course in the database
* */
@Entity(tableName = "course_table")
data class Course(
    @PrimaryKey
    val id: String,
    val title: String?
)

//Includes details of note_table and course_table
data class ExpandedNote(
    val id: Long,
    var courseTitle: String?,
    var summary: String?
)