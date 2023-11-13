package com.example.organisator

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat

class TestNotificationManager(private val context: Context) {

    fun sendTestNotification() {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("default", "Test Notification", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val largeIcon = BitmapFactory.decodeResource(context.resources, R.mipmap.app_icon_foreground)
        val notification = NotificationCompat.Builder(context, "default")
            .setContentTitle("Test")
            .setContentText("Hier sind Ihre heutigen Einträge!")
            .setSmallIcon(android.R.drawable.star_big_on)
            .setLargeIcon(largeIcon)
            .build()


        notificationManager.notify(1, notification)
    }
}
