package com.nduati.aadtestguide.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.nduati.aadtestguide.R
import com.nduati.aadtestguide.models.Notes
import kotlinx.android.synthetic.main.notes_list_item.view.*

class NotesAdapter(val notes : List<Notes>) : RecyclerView.Adapter<NotesAdapter.NotesHolder>() {

    class NotesHolder(view : View): RecyclerView.ViewHolder(view){
        val notedID : TextView = view.notedId
        val noteHeader : TextView = view.noteHeader
        val noteDescription : TextView = view.noteDescription
        val container : ConstraintLayout = view.singleNoteContainer
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_list_item, parent, false)
        return NotesHolder(view)
    }

    override fun onBindViewHolder(holder: NotesHolder, position: Int) {
        holder.notedID.text = notes[position].id.toString()
        holder.noteHeader.text = notes[position].header
        holder.noteDescription.text = notes[position].desc
        holder.container.setOnClickListener {
            val bundle = bundleOf("noteId" to position)
            it.findNavController().navigate(R.id.action_notesFragment_to_editNotesFragment, bundle)
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}