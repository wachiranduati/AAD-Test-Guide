package com.nduati.aadtestguide.services.boundservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.widget.Toast

class BoundServiceBinder : Service() {

    private val mBinder = MyLocalBinder()

    override fun onBind(intent: Intent?): IBinder? {
        Toast.makeText(this, "service bound", Toast.LENGTH_SHORT).show()
        return mBinder
    }

    inner class MyLocalBinder(): Binder(){
        fun getService() : BoundServiceBinder{
            return this@BoundServiceBinder
        }
    }
}