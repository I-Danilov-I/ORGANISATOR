package com.example.organisator

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

class TestNotificationManager(private val context: Context) {

    fun sendTestNotification() {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("default", "Test Notification", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(context, "default")
            .setContentTitle("Testbenachrichtigung")
            .setContentText("Dies ist eine Testbenachrichtigung!")
            .setSmallIcon(android.R.drawable.ic_menu_today)
            .build()

        notificationManager.notify(1, notification)
    }
}
