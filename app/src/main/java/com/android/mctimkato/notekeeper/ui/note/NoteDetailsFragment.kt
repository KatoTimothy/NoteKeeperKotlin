package com.android.mctimkato.notekeeper.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.mctimkato.notekeeper.data.NoteInfo
import com.android.mctimkato.notekeeper.databinding.FragmentNoteDetailsBinding

class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetailsBinding

    private lateinit var noteViewModel: NoteDetailsViewModel

    private lateinit var arguments: NoteFragmentArgs

    private var note: NoteInfo? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNoteDetailsBinding.inflate(inflater)

        arguments = NoteFragmentArgs.fromBundle(requireArguments())

        binding.lifecycleOwner = viewLifecycleOwner

        //initialize the viewModel
        noteViewModel = ViewModelProvider(this).get(NoteDetailsViewModel::class.java)

        //assign a viewModel to binding object

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

    }
}

//Stores state of wether we editing new or existing note
enum class EditingState {
    EXISTING_NOTE, NEW_NOTE
}