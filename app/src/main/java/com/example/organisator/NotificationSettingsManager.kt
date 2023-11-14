package com.example.organisator

import android.content.Context
import android.content.Intent

class NotificationSettingsManager(private val context: Context) {

    fun openNotificationSettings() {
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
}

