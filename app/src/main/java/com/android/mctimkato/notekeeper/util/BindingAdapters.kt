package com.android.mctimkato.notekeeper.util

import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.mctimkato.notekeeper.data.CourseInfo
import com.android.mctimkato.notekeeper.data.NoteInfo
import com.android.mctimkato.notekeeper.notelist.NoteAdapter

//Used to bind recycler view with data
@BindingAdapter("listData")
fun RecyclerView.bindListData(data: List<NoteInfo>?) {
    data?.let {
        //get adapter
        val adapter = this.adapter as NoteAdapter
        //set adapter with data
        adapter.submitList(it)
    }
}

//used to bind spinner with data and also set selected item in the spinner
@BindingAdapter(value = ["spinnerData", "selectedSpinnerCourse"])
fun Spinner.bindSpinnerData(courseList: List<CourseInfo>?, noteInfo: NoteInfo?) {
    courseList?.let {
        val adapter = ArrayAdapter(
            context,
            android.R.layout.simple_list_item_1, courseList
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
//        set adapter to spinner
        this.adapter = adapter

        //obtain the selected course
        val selectedCourse = courseList.indexOf(noteInfo?.course)
        this.setSelection(selectedCourse)
    }
}
