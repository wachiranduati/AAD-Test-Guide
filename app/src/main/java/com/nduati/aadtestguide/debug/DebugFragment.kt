package com.nduati.aadtestguide.debug

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nduati.aadtestguide.R
import java.lang.ArithmeticException

class DebugFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_debug, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(Companion.TAG, "onViewCreated: the view has been created")
        tryZeroDivision()
    }

    private fun tryZeroDivision() {
        try {
            val x = 34/0
        }catch (e : ArithmeticException){
            Log.d(TAG, "tryZeroDivision: division by zero caught ", e)
        }
    }

    companion object {
        private const val TAG = "DebugFragment"
    }

}