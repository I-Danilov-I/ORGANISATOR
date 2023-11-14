package com.example.organisator

import android.app.AlertDialog
import android.content.Context
import android.content.Intent

class NotificationManager(private val context: Context) {

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
        AlertDialog.Builder(context)
            .setTitle("Benachrichtigung Aktivieren")
            .setMessage("Wir Respektieren ihre Wahl! " +
                    "Es wird jedoch Empfolen die Benachrichtugung für diese App zu Aktivieren." +
                    "Benachrichtigungseinstellungen öffnen? ")
            .setPositiveButton("Ja") { _, _ ->
                openNotificationSettings()
            }
            .setNegativeButton("Nein", null)
            .show()
    }
}
