package com.nduati.aadtestguide.services

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.content.Context
import android.os.IBinder
import android.widget.Toast

class BackgroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "background service started", Toast.LENGTH_SHORT).show()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "background service destroyed", Toast.LENGTH_SHORT).show()
    }

}