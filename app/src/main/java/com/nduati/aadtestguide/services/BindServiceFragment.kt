package com.nduati.aadtestguide.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nduati.aadtestguide.R
import com.nduati.aadtestguide.services.boundservice.BoundServiceBinder

class BindServiceFragment : Fragment() {
    private var mService = BoundServiceBinder()
    private var mBound = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bind_service, container, false)
    }

    override fun onStart() {
        super.onStart()
        //bind to local service
        val intent : Intent = Intent(activity, BoundServiceBinder::class.java)
        activity?.bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val intent : Intent = Intent(activity, BoundServiceBinder::class.java)
    }

    override fun onStop() {
        super.onStop()
    }

    /** Defines callbacks for service binding, passed to bindService() */
    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName,
                                        service: IBinder
        ) {
            val binder = service as BoundServiceBinder.MyLocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mBound = false
        }
    }
}