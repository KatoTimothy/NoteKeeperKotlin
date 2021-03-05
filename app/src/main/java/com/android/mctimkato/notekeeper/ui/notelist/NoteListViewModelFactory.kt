package com.android.mctimkato.notekeeper.ui.notelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class NoteListViewModelFactory: ViewModelProvider
.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteListViewModel::class.java)) {
            return NoteListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}