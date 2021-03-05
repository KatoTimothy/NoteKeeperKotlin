package com.android.mctimkato.notekeeper.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.mctimkato.notekeeper.room.entities.Note

//Used to bind recycler view with data
@BindingAdapter("listData")
fun RecyclerView.bindListData(data: List<Note>) {

}
