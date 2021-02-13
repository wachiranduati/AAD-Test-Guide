package com.nduati.aadtestguide

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nduati.aadtestguide.adapter.NotesAdapter
import com.nduati.aadtestguide.adapter.TestGuidelineAdapter
import com.nduati.aadtestguide.datamanagement.NoteViewModel
import com.nduati.aadtestguide.models.Notes
import kotlinx.android.synthetic.main.fragment_notes.view.*

class NotesFragment : Fragment(), View.OnClickListener {
    lateinit var fabBtn : FloatingActionButton
    lateinit var inputFAB : FloatingActionButton
    lateinit var root : View
    lateinit var notesvwmdl : NoteViewModel
    private val TAG = "NotesFragment"
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_notes, container, false)
        notesvwmdl = ViewModelProvider(this).get(NoteViewModel::class.java)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabBtn = root.takeMeToCreateNotes
        inputFAB = root.userInputFAB
        fabBtn.setOnClickListener(this)
        inputFAB.setOnClickListener(this)

        val recyclMain = view.findViewById<RecyclerView>(R.id.RecyclerViewNotes)


        activity?.let { frgAct ->
            notesvwmdl.allNotes.observe(frgAct, androidx.lifecycle.Observer {
                val adp = NotesAdapter(it)
                val lytmng = LinearLayoutManager(activity)
                recyclMain.apply {
                    adapter = adp
                    setHasFixedSize(true)
                    layoutManager = lytmng
                }
            })
        }


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.takeMeToCreateNotes -> {
                v.findNavController().navigate(R.id.action_notesFragment_to_createNotesFragment)
            }
            R.id.userInputFAB -> {
                v.findNavController().navigate(R.id.action_notesFragment_to_userInputFragment)
            }
        }
    }

}