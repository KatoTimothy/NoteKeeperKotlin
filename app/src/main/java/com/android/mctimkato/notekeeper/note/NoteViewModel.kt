package com.android.mctimkato.notekeeper.note

import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.android.mctimkato.notekeeper.data.CourseInfo
import com.android.mctimkato.notekeeper.data.DataManager
import com.android.mctimkato.notekeeper.data.NoteInfo

/*
* ViewModel for the NoteFragment*/
class NoteViewModel : ViewModel() {

    //Contains a Hash map of CourseInfo objects
    private val courses = liveData {
        emit(DataManager.courses)
    }

    //Contains a mutable list of courses
    //This List is used to by ArrayAdapter to create a spinner in the NoteFragment
    val courseListLiveData = Transformations.map(courses) {
        it.values.toList()
    }

    //retrieves a note at a particular index
    fun get(index: Int): NoteInfo {
        return DataManager.get(index)
    }

    //Handles data insertions and updates to the data store
    fun addData(
        notePosition: Int,
        courseInfo: CourseInfo,
        title: String,
        text: String
    ) {
        val note = NoteInfo(courseInfo, title, text)

        when {
            //We can only update an existing note
            notePosition >= 0 -> update(notePosition, note)

            //For a note with an empty text or title  we never perform an insert operation
            (!note.text.isNullOrEmpty() || !note.title.isNullOrEmpty()) -> insert(note)
            else -> return
        }
    }
}

//creates a note in the data store
private fun insert(newNote: NoteInfo) {
    DataManager.insert(newNote)
}

//updates data of a particular note
private fun update(index: Int, noteInfo: NoteInfo) {
    DataManager.update(index, noteInfo)
}
