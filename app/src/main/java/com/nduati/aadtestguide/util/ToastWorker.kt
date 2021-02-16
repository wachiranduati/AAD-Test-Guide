package com.nduati.aadtestguide.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ToastWorker(context : Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {

        GlobalScope.launch {
            Log.d(Companion.TAG, "doWork: this is run in a worker by work manager")
        }
        return Result.success()
    }

    companion object {
        private const val TAG = "ToastWorker"
    }

}