package com.nduati.aadtestguide.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.notes_list_item.view.*

class NotesAdapter() : RecyclerView.Adapter<NotesAdapter.notesHolder>() {

    class notesHolder(view : View): RecyclerView.ViewHolder(view){
        val notedID : TextView = view.notedId
        val noteHeader : TextView = view.noteHeader
        val noteDescription : TextView = view.noteDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: notesHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}