package com.example.organisator

import android.app.AlertDialog
import android.content.Context

class NotificationDialogManager(private val context: Context, private val notificationSettingsManager: NotificationSettingsManager) {

    fun showNotificationSettingsDialog() {
        AlertDialog.Builder(context)
            .setTitle("Benachrichtigung Aktivieren")
            .setMessage("Wir Respektieren ihre Wahl! " +
                    "Es wird jedoch Empfolen die Benachrichtugung für diese App zu Aktivieren." +
                    "Benachrichtigungseinstellungen öffnen? ")
            .setPositiveButton("Ja") { _, _ ->
                notificationSettingsManager.openNotificationSettings()
            }
            .setNegativeButton("Nein", null)
            .show()
    }
}
