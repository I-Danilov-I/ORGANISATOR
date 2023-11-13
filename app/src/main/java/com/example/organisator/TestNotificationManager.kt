package com.example.organisator

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
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

        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_MUTABLE)

        val largeIcon = BitmapFactory.decodeResource(context.resources, R.mipmap.app_icon_foreground)
        val notification = NotificationCompat.Builder(context, "default")
            .setContentTitle("Test")
            .setContentText("Hier sind Ihre heutigen Einträge!")
            .setSmallIcon(R.mipmap.app_icon_foreground)
            .setLargeIcon(largeIcon)
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(1, notification)
    }
}
