package com.nduati.aadtestguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nduati.aadtestguide.adapter.NotesAdapter
import com.nduati.aadtestguide.adapter.TestGuidelineAdapter
import com.nduati.aadtestguide.models.Notes
import kotlinx.android.synthetic.main.fragment_notes.view.*

class NotesFragment : Fragment(), View.OnClickListener {
    lateinit var fabBtn : FloatingActionButton
    lateinit var root : View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_notes, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fabBtn = root.takeMeToCreateNotes
        fabBtn.setOnClickListener(this)

        val recyclMain = view.findViewById<RecyclerView>(R.id.RecyclerViewNotes)
        var notes : ArrayList<Notes> = arrayListOf(
            Notes(1, "first header", "first description"),
            Notes(2, "second header", "second description"),
            Notes(3, "third header", "third description"),
            Notes(4, "fourth header", "fourth description"),
            Notes(5, "fifth header", "fifth description"),
            Notes(6, "sixth header", "sixth description"),
            Notes(7, "seventh header", "seventh description"),
        )
        val adp = NotesAdapter(notes)
        val lytmng = LinearLayoutManager(activity)
        recyclMain.apply {
            adapter = adp
            setHasFixedSize(true)
            layoutManager = lytmng
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.takeMeToCreateNotes -> {
                v.findNavController().navigate(R.id.action_notesFragment_to_createNotesFragment)
            }
        }
    }

}