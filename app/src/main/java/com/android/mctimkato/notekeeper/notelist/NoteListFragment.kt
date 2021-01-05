package com.android.mctimkato.notekeeper.notelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.android.mctimkato.notekeeper.data.DataManager
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

        noteListViewModelFactory = NoteListViewModelFactory(DataManager)

        //ViewModelFactory is used to create and initialize  viewModel with list of notes
        noteListViewModel =
            ViewModelProvider(this, noteListViewModelFactory).get(NoteListViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_note_list, container, false)

        //assign viewModel to binding
        binding.noteListViewModel = noteListViewModel

        //Navigate to NoteFragment on clicking an item
        val adapter = NoteAdapter(onItemClick = { itemPosition ->
            val action = NoteListFragmentDirections.actionNavNotesToNoteFragment(itemPosition)
            this.findNavController().navigate(action)
        })


        //set adapter to the recycler view
        binding.recyclerView.adapter = adapter

        binding.lifecycleOwner = this

        binding.fab.setOnClickListener { fabView ->
            val action = NoteListFragmentDirections.actionNavNotesToNoteFragment()
            fabView.findNavController().navigate(action)
        }
        return binding.root
    }
}