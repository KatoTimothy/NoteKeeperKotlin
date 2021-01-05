package com.android.mctimkato.notekeeper.data
/*&
* Contains information about a course
* */
data class CourseInfo(val courseId: String, val title: String) {
    //returns a string representation of the class
    override fun toString(): String {
        return title
    }
}

