package com.android.mctimkato.notekeeper.domain

/**
 * This contains information about the note to be displayed in the UI
 * */

data class Note(
    val id: Int,
    val courseId: String,
    val summary: String
)
