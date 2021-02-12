package com.nduati.aadtestguide

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.nduati.aadtestguide.datamanagement.NoteViewModel
import com.nduati.aadtestguide.models.Notes
import kotlinx.android.synthetic.main.fragment_edit_notes.*
import kotlinx.android.synthetic.main.fragment_edit_notes.view.*

class EditNotesFragment : Fragment() {
    lateinit var root : View
    var noteid = 0
    lateinit var notesViewModel : NoteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_edit_notes, container, false)
        noteid = arguments?.getInt("noteId") ?: 0
        notesViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.updateNoteButton.setOnClickListener {
            var header = view.updateHeaderEditText.text.toString()
            var desc = view.updateDescriptionEditText.text.toString()
            val nuNot = Notes(header, desc)
            nuNot.id = noteid
            notesViewModel.updateNote(nuNot)
        }
    }
    
}