package com.example.secondrecyclerviewapp

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        firebaseAnalytics.logEvent("testing_service", null)

        // Log the notification received event
        logNotificationReceivedEvent(remoteMessage)

       // handleNotificationClick(remoteMessage)
    }

    private fun logNotificationReceivedEvent(remoteMessage: RemoteMessage) {
        val bundle = Bundle().apply {
            putString("notification_id", remoteMessage.messageId)
            putString("notification_title", remoteMessage.notification?.title ?: "No Title")
            putString("notification_body", remoteMessage.notification?.body ?: "No Body")
//            putString("notification_type", remoteMessage.data["type"]) // Custom data from notification
        }

        // Log custom event for notification received
        firebaseAnalytics.logEvent("random_notification_received", bundle)
    }

    private fun handleNotificationClick(remoteMessage: RemoteMessage) {
        val bundle = Bundle().apply {
            putString("notification_id", remoteMessage.messageId)
            putString("notification_title", remoteMessage.notification?.title ?: "No Title")
            putString("notification_body", remoteMessage.notification?.body ?: "No Body")
   //         putString("notification_type", remoteMessage.data["type"]) // Custom data from notification
        }

        // Log the notification clicked event
        firebaseAnalytics.logEvent("random_notification_clicked", bundle)

        // Handle the notification click (open activity, etc.)
        val intent = Intent(this, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            putExtra("extra_data", remoteMessage.data["key"])
        }

        val pendingIntent = PendingIntent.getActivity(this, 0, intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE)
        pendingIntent.send() // Launch the activity
    }

}
