package com.nduati.aadtestguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_create_notes.view.*

class CreateNotesFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.createNoteButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.createNoteButton -> {

            }
        }
    }

}