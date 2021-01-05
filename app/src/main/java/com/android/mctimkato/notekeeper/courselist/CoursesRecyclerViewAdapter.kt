package com.android.mctimkato.notekeeper.courselist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.android.mctimkato.notekeeper.data.CourseInfo
import com.android.mctimkato.notekeeper.databinding.ItemListCourseBinding
import com.google.android.material.snackbar.Snackbar

class CoursesRecyclerViewAdapter(val courses: ArrayList<CourseInfo>) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListCourseBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val course = courses[position]

    }

    override fun getItemCount() = courses.size

    inner class ViewHolder(val binding: ItemListCourseBinding) : RecyclerView.ViewHolder(binding.root) {
        val description = binding.descriptionText
    }
}