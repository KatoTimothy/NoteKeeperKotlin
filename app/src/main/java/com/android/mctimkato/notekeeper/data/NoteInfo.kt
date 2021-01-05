package com.android.mctimkato.notekeeper.data

//Stores data about a particular note
data class NoteInfo(
    var course: CourseInfo? = null, var title: String? = null, var text: String? = null
) {
    override fun toString(): String {
        return "${course?.courseId}|$title|$text"
    }
}
