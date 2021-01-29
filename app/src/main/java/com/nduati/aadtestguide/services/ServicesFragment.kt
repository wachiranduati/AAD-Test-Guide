package com.nduati.aadtestguide.services

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nduati.aadtestguide.R
import kotlinx.android.synthetic.main.fragment_services.view.*

class ServicesFragment : Fragment(), View.OnClickListener {
    lateinit var root : View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_services, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root.StartServiceButton.setOnClickListener(this)
        root.StopServiceButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.StartServiceButton -> {
                Toast.makeText(activity, "start service", Toast.LENGTH_SHORT).show()
                ForegroundService.startService(v.context, "foreground service running")
            }
            R.id.StopServiceButton -> {
                Toast.makeText(activity, "stop service", Toast.LENGTH_SHORT).show()
                ForegroundService.stopService(v.context)
            }
        }
    }
}