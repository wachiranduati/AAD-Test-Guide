package com.nduati.aadtestguide

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.findNavController

class AndroidCoreFragment : Fragment() {
    lateinit var NavToServices : Button
    lateinit var notificationBtn : Button
    lateinit var contentRcvBtn : Button
    lateinit var root : View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_android_core, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavToServices = view.findViewById(R.id.ServicesButton)
        NavToServices.setOnClickListener {
            view.findNavController().navigate(R.id.action_androidCoreFragment_to_servicesFragment)
        }


        notificationBtn = view.findViewById(R.id.notificationButton)
        notificationBtn.setOnClickListener {
            Toast.makeText(view.context, "show notification", Toast.LENGTH_SHORT).show()
            createNotificationChannel()
        }

        contentRcvBtn = view.findViewById(R.id.contentReceiverButton)
        contentRcvBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_androidCoreFragment_to_contentReceiverFragment)
        }


    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "CHANNEL_ID"
            val descriptionText = "Random description text"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
        var builder = NotificationCompat.Builder(root.context, "CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_hearts)
            .setContentTitle("AAD Test Guide App")
            .setContentText("This is a simple notification created for the AAD Test Guide App")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        with(NotificationManagerCompat.from(root.context)) {
            notify(12, builder.build())
        }

    }

}