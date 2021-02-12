package com.nduati.aadtestguide

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.nduati.aadtestguide.datamanagement.NoteViewModel
import com.nduati.aadtestguide.models.Notes
import kotlinx.android.synthetic.main.fragment_create_notes.view.*

class CreateNotesFragment : Fragment(), View.OnClickListener {
    lateinit var notesvwmdl : NoteViewModel
    var headerTxt = ""
    var descTxt = ""
    lateinit var root : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        notesvwmdl = ViewModelProvider(this).get(NoteViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_create_notes, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.createNoteButton.setOnClickListener {
            Toast.makeText(view.context, "note added", Toast.LENGTH_SHORT).show()
            headerTxt = root.headerEditText.text.toString()
            descTxt = root.descriptionEditText.text.toString()
            notesvwmdl.addNote(Notes(headerTxt, descTxt))
        }

    }

    override fun onClick(v: View?) {
//        when(v?.id){
//            R.id.createNoteButton -> {
//                Toast.makeText(v.context, "note added", Toast.LENGTH_SHORT).show()
//                headerTxt = root.headerEditText.text.toString()
//                descTxt = root.descriptionEditText.text.toString()
//                Log.d(Companion.TAG, "onClick: ${headerTxt}, description -> ${descTxt}")
////                notesvwmdl.addNote(Notes(headerTxt, descTxt))
//            }
//        }
    }

    companion object {
        private const val TAG = "CreateNotesFragment"
    }

}