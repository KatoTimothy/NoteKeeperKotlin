package com.android.mctimkato.notekeeper.notelist

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.android.mctimkato.notekeeper.data.DataManager
import com.android.mctimkato.notekeeper.R
import com.android.mctimkato.notekeeper.SettingsActivity
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
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(requireContext(), SettingsActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)

        }

    }

}