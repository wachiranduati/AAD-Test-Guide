package com.nduati.aadtestguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController

class AndroidCoreFragment : Fragment() {
    lateinit var NavToServices : Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_android_core, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavToServices = view.findViewById(R.id.ServicesButton)
        NavToServices.setOnClickListener {
//            Toast.makeText(view.context, "I've been clicked", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_androidCoreFragment_to_servicesFragment)
        }
    }

}