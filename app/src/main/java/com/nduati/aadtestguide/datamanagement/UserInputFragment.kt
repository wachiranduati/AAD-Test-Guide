package com.nduati.aadtestguide.datamanagement

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nduati.aadtestguide.R
import kotlinx.android.synthetic.main.fragment_user_input.view.*

class UserInputFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readfromSharedPref(view)
        view.savedToSharedPrefBtn.setOnClickListener {
            Toast.makeText(view.context, "saved to sharepref", Toast.LENGTH_SHORT).show()
            writeToSharedPref(view.userInputText.text.toString())
        }
    }

    private fun readfromSharedPref(view: View) {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val defaultValue = "There's nothing currently saved"
        val highScore = sharedPref.getString("com.nduati.aadtestguide.sharedpref", defaultValue)
        view.savedSharedPrefText.text = highScore
    }

    private fun writeToSharedPref(str : String) {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString("com.nduati.aadtestguide.sharedpref", str)
            apply()
        }
    }
}