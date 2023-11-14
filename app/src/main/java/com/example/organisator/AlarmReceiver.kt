package com.example.organisator

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("default", "Daily Notification", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val activityIntent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, activityIntent, PendingIntent.FLAG_MUTABLE)

        val largeIcon = BitmapFactory.decodeResource(context.resources, R.mipmap.app_icon_foreground)
        val notification = NotificationCompat.Builder(context, "default")
            .setContentTitle("Tägliche Erinnerung")
            .setContentText("Hier sind Ihre Einträge!")
            .setSmallIcon(android.R.drawable.star_big_on)
            .setLargeIcon(largeIcon)
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(1, notification)
    }
}
