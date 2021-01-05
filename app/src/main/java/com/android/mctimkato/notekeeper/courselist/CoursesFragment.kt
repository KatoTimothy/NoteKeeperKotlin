package com.android.mctimkato.notekeeper.courselist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.android.mctimkato.notekeeper.data.CourseInfo
import com.android.mctimkato.notekeeper.data.DataManager
import com.android.mctimkato.notekeeper.databinding.FragmentCoursesBinding

class CoursesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCoursesBinding.inflate(inflater)

        //set up layout manager
        binding.itemCourses.layoutManager = GridLayoutManager(context, 2)
        //set up adapter
        binding.itemCourses.adapter =
            CoursesRecyclerViewAdapter(DataManager.courses.values.toList() as ArrayList<CourseInfo>)

        return binding.root
    }

}