package com.android.mctimkato.notekeeper.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.android.mctimkato.notekeeper.R
import com.android.mctimkato.notekeeper.data.CourseInfo
import com.android.mctimkato.notekeeper.data.DataManager
import com.android.mctimkato.notekeeper.data.NoteInfo
import com.android.mctimkato.notekeeper.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding

    private lateinit var noteViewModel: NoteViewModel

    private lateinit var arguments: NoteFragmentArgs

    private var note: NoteInfo? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNoteBinding.inflate(inflater)

        arguments = NoteFragmentArgs.fromBundle(requireArguments())

        binding.lifecycleOwner = viewLifecycleOwner

        //initialize the viewModel
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        //assign a viewModel to binding object
        binding.noteViewModel = noteViewModel

        val editing: Editing = if (arguments.notePosition >= 0) Editing.EXISTING else Editing.NEW

        if (editing == Editing.EXISTING) {
            binding.note = noteViewModel.get(arguments.notePosition)
        }
        return binding.root
    }


    /*
    * Automatic saving of changes in the are handled here*/
    override fun onPause() {
        super.onPause()
        saveNote()
    }

    /*
    * Automatically saves changes in the note when user hits back button
    * */
    private fun saveNote() {
        val selectedCourse = binding.spinnerCourses.selectedItem as CourseInfo
        val title = binding.noteTitle.text.toString()
        val text = binding.descriptionText.text.toString()

        note = NoteInfo(selectedCourse, title, text)

        noteViewModel.addData(arguments.notePosition, selectedCourse, title, text)
    }
}

enum class Editing {
    EXISTING, NEW
}