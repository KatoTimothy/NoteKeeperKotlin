package com.android.mctimkato.notekeeper.ui.notelist

import androidx.lifecycle.ViewModel
import com.android.mctimkato.notekeeper.data.DataManager
import com.android.mctimkato.notekeeper.data.NoteInfo

class NoteListViewModel(private val dataSouce: DataManager) : ViewModel() {

    //This list is  be observed by NoteListFragment to display contained data as  list in
    // RecyclerView
    val notes = dataSouce.getAllNotes()

    fun insert() {
        val newNote = NoteInfo()
        dataSouce.insert(newNote)
    }
}