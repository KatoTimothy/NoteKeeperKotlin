package com.android.mctimkato.notekeeper.notelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.mctimkato.notekeeper.data.DataManager
import com.android.mctimkato.notekeeper.data.NoteInfo
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class NoteListViewModelFactory(private val dataSource: DataManager) : ViewModelProvider
.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteListViewModel::class.java)) {
            return NoteListViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}