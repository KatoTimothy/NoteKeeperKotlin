package com.android.mctimkato.notekeeper.ui.notelist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.mctimkato.notekeeper.R
import com.android.mctimkato.notekeeper.databinding.FragmentNoteListBinding

class NoteListFragment : Fragment() {

    //Store reference to binding object
    private lateinit var binding: FragmentNoteListBinding

    //Stores reference to viewModelFactory
    private lateinit var noteListViewModelFactory: NoteListViewModelFactory

    private lateinit var noteListViewModel: NoteListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //initialize view model
        noteListViewModel =
            ViewModelProvider(this, noteListViewModelFactory).get(NoteListViewModel::class.java)

        binding = FragmentNoteListBinding.inflate(inflater)

        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

}