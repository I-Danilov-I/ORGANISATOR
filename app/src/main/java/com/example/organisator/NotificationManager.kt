package com.example.organisator

import android.app.AlarmManager
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import java.util.*

class NotificationManager(private val context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("NotificationPrefs", Context.MODE_PRIVATE)

    private fun openNotificationSettings() {
        val intent = Intent().apply {
            action = "android.settings.APP_NOTIFICATION_SETTINGS"

            // for Android 5-7
            putExtra("app_package", context.packageName)
            putExtra("app_uid", context.applicationInfo.uid)

            // for Android 8 and above
            putExtra("android.provider.extra.APP_PACKAGE", context.packageName)
        }

        context.startActivity(intent)
    }

    fun showNotificationSettingsDialog() {
        if (!sharedPreferences.getBoolean("dialogShown", false)) {
            AlertDialog.Builder(context)
                .setTitle("Benachrichtigung Aktivieren")
                .setMessage("Wir Respektieren ihre Wahl! \n" +
                        "Es wird jedoch Empfolen die Benachrichtugung für diese App zu Aktivieren.\n\n" +
                        "Benachrichtigungseinstellungen öffnen? ")
                .setPositiveButton("Ja") { _, _ ->
                    openNotificationSettings()
                    sharedPreferences.edit().putBoolean("dialogShown", true).apply()
                }
                .setNegativeButton("Nein", null)
                .show()
        }
    }

    fun setupDailyNotification() {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent,
            PendingIntent.FLAG_MUTABLE)

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 8)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
        }

        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }
}

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

