package com.android.mctimkato.notekeeper.database.entities

/*
* Represents a single entry of note in the database
* */
data class NoteEntity(
    val id: Int,
    val courseId: String,
    val summary: String
)

/*
* Represents a single entry of course in the database
* */
data class CourseEntity(
    val id: String,
    val title: String
)