package com.android.mctimkato.notekeeper.notelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.mctimkato.notekeeper.data.NoteInfo
import com.android.mctimkato.notekeeper.databinding.ItemListNoteBinding

class NoteAdapter(
    val onItemClick: (position: Int) -> Unit
) : ListAdapter<NoteInfo, NoteAdapter.ViewHolder>(NoteInfoDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListNoteBinding.inflate(inflater, parent, false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val noteItem = getItem(position)
        holder.bind(noteItem)
    }

    /*
    * ViewHolder for the noteInfo adapter
    * */
    class ViewHolder(
        private val binding: ItemListNoteBinding,
        private val onItemClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(noteItem: NoteInfo) {
            binding.note = noteItem
            binding.executePendingBindings()

            //set an item click listener passing in position of clicked item
            binding.root.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

    }
}

/*
* Used by the recyclerview to efficiently update the list it displays
*  */
class NoteInfoDiffUtil : DiffUtil.ItemCallback<NoteInfo>() {
    override fun areContentsTheSame(oldItem: NoteInfo, newItem: NoteInfo): Boolean {
        return oldItem.text == newItem.text
    }

    override fun areItemsTheSame(oldItem: NoteInfo, newItem: NoteInfo): Boolean {
        return oldItem == newItem
    }
}