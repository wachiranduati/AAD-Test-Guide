package com.nduati.aadtestguide.util

import android.content.Context
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class ToastWorker(context : Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {
        Toast.makeText(applicationContext, "This is run by a worker", Toast.LENGTH_SHORT).show()
        return Result.success()
    }

}